package com.leet.algo;

public class Prob887 {
	/**
	 *  https://leetcode.com/problems/super-egg-drop/submissions/
	 * @param K
	 * @param N
	 * @return
	 */
	public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 1; i <= N; i++) {
        	dp[1][i] = i;
        }
        for (int i = 1; i <= K; i++) {
        	dp[i][1] = 1;
        }
        for (int i = 2; i <= K; i++) {
        	for (int j = 2; j <= N; j++) {
        		int low = 1, high = j;
        		while(low + 1 < high) {
        			int x = (low + high) / 2;
        			int t1 = dp[i - 1][x - 1];
        			int t2 = dp[i][j - x];
        			if(t1 < t2) low = x;
        			else if(t1 > t2) high = x;
        			else {
        				low = x;
        				high = x;
        			}
        		}
        		dp[i][j] = 1 + Math.min(Math.max(dp[i - 1][low - 1], dp[i][j - low]), Math.max(dp[i - 1][high - 1], dp[i][j - high]));
        	}
        	
        }
        return dp[K][N];
    }
}
