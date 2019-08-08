package com.leet.algo;

public class Prob1035 {
	public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
      //dp[i][j] stands for the maximum number of connecting lines between A[0:i - 1] and B[0:j - 1]
        for (int i = 0; i < A.length; i++) {
        	for (int j = 0; j < B.length; j++) {
        		if(A[i] == B[j]) dp[i + 1][j + 1] = 1 + dp[i][j];
        		else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        	}
        }
        return dp[A.length][B.length];
    }
}
