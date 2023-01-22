package com.prep2020.hard;

public class Problem1216 {
	/**
	 * O(N^2)
	 * find max subsequence
	 * @param s
	 * @param k
	 * @return
	 */
	public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
        	for (int j = 0; j + i <= n; j++) {
        		if (s.charAt(j) == s.charAt(j + i - 1)) {
        			dp[j][j + i - 1] = 2 + (i > 2 ? dp[j + 1][j + i - 2] : 0);
        		} else dp[j][j + i - 1] = Math.max(dp[j][j + i - 2], dp[j + 1][j + i - 1]);
        		max = Math.max(max, dp[j][j + i - 1]);
        	}
        }
        return n - max <= k;
    }
	
	public static void main(String[] args) {
		Problem1216 problem = new Problem1216();
		System.out.println(problem.isValidPalindrome("abcdeca", 2));
	}
}
