package com.prep2020.medium;

import java.util.*;

public class Problem1409 {
	/**
	 * O(M*N)
	 * @param queries
	 * @param m
	 * @return
	 */
	public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) list.add(i + 1);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
        	int idx = findIndex(list, queries[i]);
        	result[i] = idx;
        	list.add(0, list.remove(idx));
        }
        return result;
    }
	
	private int findIndex(List<Integer> list, int val) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == val) return i;
		}
		return -1;
	}
}
