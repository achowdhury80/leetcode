package com.prep2020.medium.more2000;

import java.util.*;

public class Problem2054 {
	/**
	 * O(nlogn)
	 * @param events
	 * @return
	 */
	public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (x, y) -> x[1] == y[1] ? (x[0] - y[0]) 
        		: (x[1] - y[1]));
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int maxVal = 0;
        for (int[] e : events) {
        	maxVal = Math.max(maxVal, e[2]);
        	treeMap.put(e[1], maxVal);
        }
        int result = 0;
        for (int[] e : events) {
        	int val = e[2];
        	Map.Entry<Integer, Integer> entry = treeMap.floorEntry(e[0] - 1);
        	if (entry != null) val += entry.getValue();
        	result = Math.max(result, val);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem2054 problem = new Problem2054();
		System.out.println(problem.maxTwoEvents(new int[][] {
			{1, 3, 2}, {4, 5, 2}, {2, 4, 3}}));
	}
}
