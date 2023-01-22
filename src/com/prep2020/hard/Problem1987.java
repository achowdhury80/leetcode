package com.prep2020.hard;

public class Problem1987 {
	public int numberOfUniqueGoodSubsequences(String binary) {
        int[][] dp = new int[2][2];
        int mod = (int)(1e9 + 7);
        for (char c : binary.toCharArray()) {
        	if (c == '0') {
        		dp[0][0] = 1;
        		dp[1][0] = dp[1][0] + dp[1][1];
        		dp[1][0] %= mod;
        	} else {
        		dp[1][1] = dp[1][0] + dp[1][1] + 1;
        		dp[1][1] %= mod;
        	}
        }
        return (dp[0][0] + dp[0][1] + dp[1][0] + dp[1][1]) % mod;
    }
}
