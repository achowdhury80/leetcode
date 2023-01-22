package com.prep2020.hard;

import java.util.Arrays;

public class Problem1547 {
	/*
	 * O(N^3) time and O(N^2) space
	 */
	public int minCost(int n, int[] cuts) {
		int m = cuts.length;
		Arrays.sort(cuts);
		// include the end cuts
		int[] arr = new int[m + 2];
		for (int i = 0; i < m; i++) arr[i + 1] = cuts[i];
		arr[m + 1] = n;
		// dp[i][j] means total cost considering from ith cut index till jth cut index. lowest value of cut index is 0 which is left end
		// and highest value of cut index is m + 1 which is right end. we need to find dp[0][m + 1]
		int[][] dp = new int[m + 2][m + 2]; // consider end points as cut 
		// i is the number of cuts considered
		for (int i = 1; i <= m; i++) {
			// j is the end cut index
			for (int j = i + 1; j < arr.length; j++) {
			 // start is the start cut index.
				int start = j - i - 1;
				int cost = Integer.MAX_VALUE;
				// length of the wood
				int len = arr[j] - arr[start];
				// find the best cut
				for (int k = start + 1; k < j; k++) {
					cost = Math.min(cost, len + dp[start][k] + dp[k][j]);
				}
				dp[start][j] = cost;
			}
		}
		return dp[0][m + 1];
    }
	
	public static void main(String[] args) {
		Problem1547 prob = new Problem1547();
		System.out.println(prob.minCost(7, new int[] {1, 3, 4, 5}));
	}
}
