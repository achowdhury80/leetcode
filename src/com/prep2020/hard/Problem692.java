package com.prep2020.hard;

public class Problem692 {
	public int kInversePairs(int n, int k) {
		if (k == 0) return 1;
		if (n < 2) return 0;
        long[][] dp = new long[n + 1][k + 1];
        long mod = (long)(1e9 + 7);
        dp[2][1] = 1;
        dp[2][0] = 1;
        for (int i = 3; i <= n; i++) {
        	for (int j = 0; j <= Math.min(k, i * (i - 1) / 2); j++) {
        		for (int x = 0; x <= Math.min(j, i - 1) ; x++) {
        			dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % mod;
        		}
        	}
        }
        return (int)dp[n][k];
    }
	
	public static void main(String[] args) {
		Problem692 problem = new Problem692();
		System.out.println(problem.kInversePairs(3, 3));
	}
}
