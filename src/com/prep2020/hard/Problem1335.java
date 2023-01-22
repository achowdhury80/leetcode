package com.prep2020.hard;

public class Problem1335 {
	public int minDifficulty(int[] jobDifficulty, int d) {
		int n = jobDifficulty.length;
		if (n < d) return -1;
        int[][] dp = new int[n][d];
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
        	dp[i][0] = Math.max(dp[i - 1][0], jobDifficulty[i]);
        }
        for (int i = 1; i < d; i++) {
        	for (int j = i; j < n; j++) {
        		int curDiff = jobDifficulty[j];
        		dp[j][i] = dp[j - 1][i - 1] + curDiff;
        		int idx = j - 1;
        		while (idx >= i) {
        			curDiff = Math.max(curDiff, jobDifficulty[idx]);
        			dp[j][i] = Math.min(dp[j][i], curDiff + dp[idx - 1][i - 1]);
        			idx--;
        		}
        	}
        }
        return dp[n - 1][d - 1];
    }
}
