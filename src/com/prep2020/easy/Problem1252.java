package com.prep2020.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem1252 {
	/**
	 * O(indices size) and o(n *m) space
	 * keep track of odd
	 * @param n
	 * @param m
	 * @param indices
	 * @return
	 */
	public int oddCells(int n, int m, int[][] indices) {
        Set<Integer> odds = new HashSet<>();
        for (int[] index : indices) {
        	for (int j = 0; j < m; j++) {
        		int num = index[0] *  m + j;
        		if (odds.contains(num)) odds.remove(num);
        		else odds.add(num);
        	}
        	for (int i = 0; i < n; i++) {
        		int num = i *  m + index[1];
        		if (odds.contains(num)) odds.remove(num);
        		else odds.add(num);
        	}
        }
        return odds.size();
    }
}
