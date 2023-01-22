package com.prep2020.hard;

public class Problem629 {
	public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int M = 1000000007;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                else {
                    int val = (dp[i - 1][j] + M - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % M;
                    dp[i][j] = (dp[i][j - 1] + val) % M;
                }
            }
        }
        return ((dp[n][k] + M - (k > 0 ? dp[n][k - 1] : 0)) % M);
    }
	
	public static void main(String[] args) {
		Problem629 prob = new Problem629();
		//System.out.println(prob.kInversePairs(10, 0));
		//System.out.println(prob.kInversePairs(10, 1));
		System.out.println(prob.kInversePairs(3, 1));
	}
}
