package com.prep2020.medium;

public class Problem343 {
	/**
	 * O(N^2) time and O(N) space
	 * @param n
	 * @return
	 */
	public int integerBreak(int n) {
		int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	if (i != n) dp[i] = i;
        	for (int j = 1; j <= i / 2; j++) {
        		dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
        	}
        }
        return dp[n];
    }
	
	public static void main(String[] args) {
		Problem343 problem = new Problem343();
		System.out.println(problem.integerBreak(10));
	}
}
