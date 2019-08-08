package com.leet.algo;

public class Problem629 {
	public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int mod = (int)(1e9 + 7);
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
        	for (int j = 0; j < i - 1 && j <= k; j++) {
        		dp[i][j] = dp[i - 1][j];
        	}
        	for (int j = 0; j < i - 1 && j < k; j++) {
        		dp[i][j + 1] = (dp[i][j + 1] + dp[i - 1][j] * (i - 1)) % mod;
        	}
        }
        return dp[n][k];
    }
	
	public static void main(String[] args) {
		Problem629 prob = new Problem629();
		//System.out.println(prob.kInversePairs(10, 0));
		//System.out.println(prob.kInversePairs(10, 1));
		System.out.println(prob.kInversePairs(3, 1));
	}
}
