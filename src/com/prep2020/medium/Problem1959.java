package com.prep2020.medium;

public class Problem1959 {
	public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
        	for (int j = 0; j <= k; j++) dp[i][j] = -1;
        }
        return dfs(nums, 0, k, dp);
    }
	
	private int dfs(int[] nums, int start, int k, int[][] dp) {
		int n = nums.length;
		if (start == n) return 0;
		if (k < 0) return Integer.MAX_VALUE;
		if (dp[start][k] != -1) return dp[start][k];
		long sum = 0, result = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = start; i < n; i++) {
			sum += nums[i];
			max = Math.max(max, nums[i]);
			result = Math.min(result, max * (i - start + 1) - sum + dfs(nums, i + 1, 
					k - 1, dp));
		}
		dp[start][k] = (int)result;
		return dp[start][k];
	}
}
