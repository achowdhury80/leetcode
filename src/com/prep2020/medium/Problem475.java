package com.prep2020.medium;
import java.util.*;
public class Problem475 {
	/**
	 * O(Nlogk + k logk)
	 * @param houses
	 * @param heaters
	 * @return
	 */
	public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int h : heaters) treeSet.add(h);
        int result = 0;
        for (int h : houses) {
        	if (!treeSet.contains(h)) {
        		int radius = Integer.MAX_VALUE;
        		Integer floor = treeSet.floor(h);
        		if (floor != null) radius = h - floor;
        		Integer ceil = treeSet.ceiling(h);
        		if (ceil != null) radius = Math.min(radius, ceil - h);
        		result = Math.max(result, radius);
        	}
        }
        return result;
    }
}
