package com.prep2020.hard;

public class Problem72 {
	/**
	 * O(MN) time and space
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
        if (m > n) return minDistance(word2, word1);
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = i;
        for (int i = 1; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <= m; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
        		else {
        			dp[i][j] = Math.min(1 + dp[i - 1][j - 1], Math.min(1 + dp[i][j - 1], 1 + dp[i - 1][j]));
        		}
        	}
        }
        return dp[m][n];
    }
}
