package com.prep2020.medium;

public class Problem651 {
	/**
	 * O(N^2)
	 * @param n
	 * @return
	 */
	public int maxA(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	dp[i] = i;
        	for (int j = 3; j < i; j++) {
        		dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
        	}
        }
        return dp[n];
    }
}
