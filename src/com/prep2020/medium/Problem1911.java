package com.prep2020.medium;
public class Problem1911 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        dp[n - 1][0] = nums[n - 1];
        for (int i = n - 2; i > -1; i--) {
            dp[i][0] = Math.max(nums[i] + dp[i + 1][1], dp[i + 1][0]);
            dp[i][1] = Math.max(-nums[i] + dp[i + 1][0], dp[i + 1][1]);
        }
        return dp[0][0];
    }
}
