package com.prep2020.medium;

public class Problem583 {
	/**
	 * O(n1 * n2)
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int[][] dp = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
        	for (int j = 0; j < n2; j++) {
        		if (word1.charAt(i) == word2.charAt(j)) 
        			dp[i][j] = 1 + ((i > 0 && j > 0) ? dp[i - 1][j - 1] : 0);
        		else 
        			dp[i][j] = Math.max(i > 0 ? dp[i - 1][j] : 0, j > 0 ? dp[i][j - 1] : 0);
        	}
        }
        return word1.length() + word2.length() - 2 * dp[n1 - 1][n2 - 1];
    }
}
