package com.prep2020.medium.more2000;

import java.util.*;

public class Problem2008 {
	/**
	 * O(NlogN)
	 * @param n
	 * @param rides
	 * @return
	 */
	public long maxTaxiEarnings(int n, int[][] rides) {
        for (int[] r : rides) r[2] += r[1] - r[0];
        Arrays.sort(rides, (x, y) ->(x[1] == y[1]) ? (x[0] - y[0]) 
        		: (x[1] - y[1]));
        long result = 0;
        TreeMap<Integer, Long> treeMap = new TreeMap<>();
        for (int[] r : rides) {
        	Map.Entry<Integer, Long> prev = treeMap.floorEntry(r[0]);
        	long earn = r[2];
        	if (prev != null) earn += prev.getValue();
        	Map.Entry<Integer, Long> entry = treeMap.floorEntry(r[1]);
        	if (entry == null || entry.getValue() < earn) {
        		treeMap.put(r[1], earn);
        		result = Math.max(result, earn);
        	}
        }
        return result;
    }
}
