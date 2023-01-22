package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2201 {
	public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Set<Integer> set = new HashSet<>();
        for (int[] d : dig) {
        	set.add((d[0] << 10) | d[1]);
        }
        int result = 0;
        for (int[] art : artifacts) {
        	boolean found = true;
        	for (int r = art[0]; r <= art[2]; r++) {
        		for (int c = art[1]; c <= art[3]; c++) {
        			if (!set.contains((r << 10) | c)) {
        				found = false;
        				break;
        			}
        		}
        		if (!found) break;
        	}
        	if (found) result++;
        }
        return result;
    }
}
