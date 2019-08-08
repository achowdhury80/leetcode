package com.leet.algo;

public class Prob813 {
	/**
	 * dp[i][j] is sum of avg of i groups with 1st to jth element
	 * @param A
	 * @param K
	 * @return
	 */
	public double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[K + 1][A.length + 1];
        double[] sum = new double[A.length + 1];
        for(int i = 1; i <= A.length; i++) {
        	sum[i] = sum[i - 1] + A[i - 1];
        	dp[1][i] = sum[i] / i;
        }
        for (int i = 2; i <= K; i++) {
        	for (int j = i; j <= A.length; j++) {
        		for (int k = i - 1; k < j ; k++) {
        			dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + (double) (sum[j] - sum[k]) / (j - k));
        		}
        		
        	}
        }
        return dp[K][A.length];
    }
}
