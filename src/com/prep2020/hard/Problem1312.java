package com.prep2020.hard;

public class Problem1312 {
	public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (i != j) dp[i][j] = Integer.MAX_VALUE;
        	}
        }
        for (int i = 2; i <= n; i++) {
        	for (int j = 0; j + i <= n ; j++) {
        		if (s.charAt(j) == s.charAt(j + i - 1)) {
        			dp[j][j + i - 1] = (i == 2 ? 0 : dp[j + 1][j + i - 2]);
        		} else {
        			if (i == 2) dp[j][j + i - 1] = 1;
        			else dp[j][j + i - 1] = 1 + Math.min(dp[j + 1][j + i - 1], dp[j][j + i - 2]);
        		}
        	}
        }
        return dp[0][n - 1];
    }
}
