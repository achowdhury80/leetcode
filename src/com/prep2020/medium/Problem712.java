package com.prep2020.medium;

public class Problem712 {
	/**
	 * O(MN) time and space
	 * @param s1
	 * @param s2
	 * @return
	 */
	public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) dp[i + 1][0] = dp[i][0] + s1.charAt(i); 
        for (int i = 0; i < n; i++) dp[0][i + 1] = dp[0][i] + s2.charAt(i); 
        for (int i = 0; i < m; i++) {
        	for (int j = 0;j < n; j++) {
        		char c1 = s1.charAt(i), c2 = s2.charAt(j);
        		if (c1 == c2) dp[i + 1][j + 1] = dp[i][j];
        		else dp[i + 1][j + 1] = Math.min(dp[i + 1][j] + c2, dp[i][j + 1] + c1);
        	}
        }
        return dp[m][n];
    }
	
	public static void main(String[] args) {
		Problem712 problem = new Problem712();
		System.out.println(problem.minimumDeleteSum("sea", "eat"));
	}
}
