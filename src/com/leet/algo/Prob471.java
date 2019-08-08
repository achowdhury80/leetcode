package com.leet.algo;

public class Prob471 {
	public String encode(String s) {
		int n = s.length();
        String[][] dp = new String[n][n];
        for (int l = 1; l <= n; l++) {
        	for (int i = 0; i + l - 1< n; i++) {
        		int j = i + l - 1;
        		dp[i][j] = s.substring(i, j + 1);
        		for (int k = i; k < j; k++) {
        			if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
        				dp[i][j] = dp[i][k] + dp[k + 1][j];
        			}
        		}
        		String cur = s.substring(i, j + 1);
        		int idx = (cur + cur).indexOf(cur, 1);
        		if (idx < cur.length()) {
        			cur = (cur.length() / idx) + "[" + dp[i][i + idx - 1] + "]";
        		}
        		if (cur.length() < dp[i][j].length()) {
        			dp[i][j] = cur;
        		}
        	}
        }
        return dp[0][n - 1];
    }
}
