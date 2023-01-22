package com.prep2020.medium;
import java.util.*;
public class Problem356 {
	public boolean isReflected(int[][] points) {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        for (int[] p : points) {
        	minX = Math.min(minX, p[0]);
        	maxX = Math.max(maxX, p[0]);
        	set.add(p[0] + ":" + p[1]);
        }
        
        int mirrorX = minX + maxX;
        for (int[] p : points) {
        	if (!set.contains((mirrorX - p[0]) + ":" + p[1])) return false;
        }
        return true;
    }
}
