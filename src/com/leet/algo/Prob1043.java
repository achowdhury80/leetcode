package com.leet.algo;

public class Prob1043 {
	public int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
        	int max = 0;
        	for (int j = 0; j < K && i - j > -1; j++) {
        		max = Math.max(max, A[i - j]);
        		dp[i] = Math.max(dp[i], max * (j + 1) + (i - j > 0 ? dp[i - j - 1] : 0));
        	}
        }
        return dp[A.length - 1];
    }
	
	public static void main(String[] args) {
		Prob1043 prob = new Prob1043();
		System.out.println(prob.maxSumAfterPartitioning(new int[] {1,15,7,9,2,5,10}, 3));
	}
}
