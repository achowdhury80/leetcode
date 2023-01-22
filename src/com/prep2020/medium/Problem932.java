package com.prep2020.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem932 {
	/**
	 * https://leetcode.com/problems/beautiful-array/solution/
	 * @param N
	 * @return
	 */
	public int[] beautifulArray(int N) {
		Map<Integer, int[]> mem = new HashMap<>();
		return helper(N, mem);
    }
	
	private int[] helper(int n, Map<Integer, int[]> mem) {
		if (mem.containsKey(n)) return mem.get(n);
		int[] result = new int[n];
		if (n == 1) result[0] = 1;
		else {
			int i = 0;
			for (int j : helper((n + 1) / 2, mem)) {
				result[i++] = 2 * j - 1;
			}
			for (int j : helper(n / 2, mem)) {
				result[i++] = 2 * j;
			}
		}
		mem.put(n, result);
		return result;
	}
}
