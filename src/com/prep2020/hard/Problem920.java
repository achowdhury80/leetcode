package com.prep2020.hard;

public class Problem920 {
	public int numMusicPlaylists(int n, int goal, int k) {
        long mod = (long)(1e9 + 7);
        long[][] dp = new long[goal + 1][n + 1];
        for (int i = 1; i <= n; i++) dp[1][i] = i;
        for (int i = 2; i <= goal; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (i > j) {
        			dp[i][j] = (((j > k ? (j - k) : 0) * dp[i - 1][j]) % mod + (j * dp[i - 1][j - 1]) % mod) % mod;
        		} else dp[i][j] = (j * dp[i - 1][j - 1]) % mod;
        	}
        }
        return (int)dp[goal][n];
    }
	
	public static void main(String[] args) {
		Problem920 problem = new Problem920();
		System.out.println(problem.numMusicPlaylists(3, 3, 1));
		System.out.println(problem.numMusicPlaylists(2, 3, 0));
	}
}
