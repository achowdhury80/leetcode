package com.prep2020.medium;

import java.util.*;

public class Problem873 {
	/**
	 * O(N^2) time and O(N^2) space
	 * @param A
	 * @return
	 */
	public int lenLongestFibSubseq(int[] arr) {
		int n = arr.length;
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < n; i++) indexMap.put(arr[i], i);
		int[][] dp = new int[n][n];
		int result = 0;
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j > -1; j--) {
				int prevVal = arr[i] - arr[j];
				int prevValIndex = indexMap.getOrDefault(prevVal, -1);
				if (prevValIndex != - 1 && prevValIndex < j) {
					dp[j][i] = 1 + dp[prevValIndex][j];
					result = Math.max(result, dp[j][i]);
				} else dp[j][i] = 2;
			}
		}
        return result;
    }
	
	public static void main(String[] args) {
		Problem873 problem = new Problem873();
		System.out.println(problem.lenLongestFibSubseq(new int[] {1,2,3,4,5,6,7,8}));
	}
}
