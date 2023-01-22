package com.prep2020.hard;

public class Problem1420 {
	public int numOfArrays(int n, int m, int k) {
        if (k == 0) return 0;
        long[][][] dp = new long[m][n][k];
        for (int i = 0; i < m; i++) dp[i][0][0] = 1;
        for (int i = 1; i <= m; i++) {
        	for (int j = 1; j <= n; j++) {
        		for (int x = 1; x <= k; x++) {
        			
        		}
        	}
        }
        return 0;
    }
}
