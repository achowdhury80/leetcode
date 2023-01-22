package com.prep2020.hard;

public class Problem1340 {
	/**
	 * O(N * d)
	 * @param arr
	 * @param d
	 * @return
	 */
	public int maxJumps(int[] arr, int d) {
		int n = arr.length;
		int[] dp = new int[n];
		int result = 0;
        for (int i = 0; i < n; i++) {
        	dp[i] = helper(arr, d, dp, i);
        	result = Math.max(result, dp[i]);
        }
        return result;
    }
	
	private int helper(int[] arr, int d, int[] dp, int i) {
		int n = arr.length;
		if (dp[i] != 0) return dp[i];
		dp[i] = 1;
		for (int j = 1; j <= d && (i + j) < n; j++) {
			if (arr[i + j] >= arr[i]) break;
			dp[i] = Math.max(dp[i], 1 + helper(arr, d, dp, i + j));
		}
		for (int j = 1; j <= d && (i - j) > -1; j++) {
			if (arr[i - j] >= arr[i]) break;
			dp[i] = Math.max(dp[i], 1 + helper(arr, d, dp, i - j));
		}
		return dp[i];
	}
	
	public static void main(String[] args) {
		Problem1340 problem = new Problem1340();
		System.out.println(problem.maxJumps(new int[] {6,4,14,6,8,13,9,7,10,6,12}, 2));
	}
}
