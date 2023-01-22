package com.prep2020.hard;

public class Problem552 {
	public int checkRecord(int n) {
		// dp[i][j][k] = number ways taking ith(1based) day j absents(0 or 1) with last k days late(0/1/2)
        long[][][] dp = new long[n + 1][2][3];
        long mod = (long)(1e9 + 7);
        for (int i = 0; i <= n; i++) {
        	dp[i][0][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
        	for (int j = 0; j < 2; j++) {
        		dp[i][j][2] = dp[i - 1][j][1];
        		dp[i][j][1] = dp[i - 1][j][0];
        		dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1] + dp[i - 1][j][2] 
        				+ (j > 0 ? (dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]) : 0)) % mod;
        	}
        }
        long result = 0;
        for (int i = 0; i < 2; i++) {
        	for (int j = 0; j < 3; j++) {
        		result = (result + dp[n][i][j]) % mod;
        	}
        }
        return (int)result;
	}
	
	public static void main(String[] args) {
		Problem552 problem = new Problem552();
		System.out.println(problem.checkRecord(2));
	}
}
