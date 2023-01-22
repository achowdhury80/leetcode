package com.prep2020.medium.more2000;

import java.util.*;

public class Problem2070 {
	public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (x, y) -> x[0] - y[0]);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int maxBeauty = 0;
        for (int[] i : items) {
        	maxBeauty = Math.max(maxBeauty, i[1]);
        	treeMap.put(i[0], maxBeauty);
        }
        int n = queries.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
        	Map.Entry<Integer, Integer> e = treeMap.floorEntry(queries[i]);
        	if (e != null) result[i] = e.getValue(); 
        }
        return result;
    }
}
