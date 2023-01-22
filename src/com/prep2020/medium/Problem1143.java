package com.prep2020.medium;

public class Problem1143 {
	/**
	 * O(M * N) time and space
	 * @param text1
	 * @param text2
	 * @return
	 */
	public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (text1.charAt(i) == text2.charAt(j)) dp[i + 1][j + 1] = 1 + dp[i][j];
        		else dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
        	}
        }
        return dp[m][n];
    }
}
