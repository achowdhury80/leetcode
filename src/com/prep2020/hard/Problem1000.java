package com.prep2020.hard;
public class Problem1000 {
	public int mergeStones(int[] stones, int k) {
		int n = stones.length;
		if ((n - 1) % (k - 1) != 0) return -1;
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) dp[i][j] = -1;
		}
		int[] preSum = new int[n + 1];
		for (int i = 0; i < n; i++) preSum[i + 1] = preSum[i] + stones[i];
		return helper(preSum, 0, n - 1, k, dp);
    }
	
	private int helper(int[] preSum, int i, int j, int k, int[][] dp) {
		if (i == j) return 0;
		if (dp[i][j] != -1) return dp[i][j];
		int result = Integer.MAX_VALUE;
		for (int x = i; x < j; x += k - 1) {
			result = Math.min(result, helper(preSum, i, x, k, dp) + helper(preSum, x + 1, j, k, dp));
		}
		if ((j - i) % (k - 1) == 0) result += preSum[j + 1] - preSum[i];
		dp[i][j] = result;
		return dp[i][j];
	}
	
	public static void main(String[] args) {
		Problem1000 problem = new Problem1000();
		//System.out.println(problem.mergeStones(new int[] {3, 2, 4, 1}, 2));
		System.out.println(problem.mergeStones(new int[] {3, 2}, 2));
	}
}
