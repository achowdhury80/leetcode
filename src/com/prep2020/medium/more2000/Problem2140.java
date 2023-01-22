package com.prep2020.medium.more2000;

public class Problem2140 {
	/**
	 * O(N) time and space
	 * @param questions
	 * @return
	 */
	public long mostPoints(int[][] questions) {
		int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];
        long result = dp[n - 1];
        for (int i = n - 2; i > -1; i--) {
        	dp[i] = Math.max(dp[i + 1], questions[i][0] + ((i + questions[i][1] + 1) < n 
        			? dp[i + questions[i][1] + 1]: 0));
        	result = Math.max(result, dp[i]);
        }
        return result;
    }
}
