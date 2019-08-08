package com.leet.algo;

public class Prob931 {
	public int minFallingPathSum(int[][] A) {
        int[] dp = new int[A.length];
        for (int i = 0; i < dp.length; i++) dp[i] = A[0][i];
        for (int i = 1; i < dp.length; i++) {
        	int[] temp = new int[A.length];
        	for (int j = 0; j < dp.length; j++) {
        		int min = dp[j];
        		if (j > 0) min = Math.min(min, dp[j - 1]);
        		if (j < dp.length - 1) min = Math.min(min, dp[j + 1]);
        		temp[j] = min + A[i][j];
        	}
        	dp = temp;
        }
        int min = dp[0];
        for (int i = 1; i < dp.length; i++) min = Math.min(min, dp[i]);
        return min;
    }
}
