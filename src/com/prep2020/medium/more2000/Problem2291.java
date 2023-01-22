package com.prep2020.medium.more2000;

public class Problem2291 {
	public int maximumProfit(int[] present, int[] future, int budget) {
		int n = future.length;
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) profit[i] = future[i] - present[i];
        int[][] dp = new int[budget + 1][n + 1];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j <= budget; j++) {
        		dp[j][i + 1] = dp[j][i];
        		if (j >= present[i]) dp[j][i + 1] = Math.max(dp[j][i + 1], profit[i] + dp[j - present[i]][i]);
        	}
        }
        return dp[budget][n];
    }
	
	public static void main(String[] args) {
		Problem2291 problem = new Problem2291();
		System.out.println(problem.maximumProfit(new int[] {5,4,6,2,3}, new int[] {8,5,4,3,5}, 10));
		
		System.out.println(problem.maximumProfit(new int[] {0}, new int[] {1}, 0));
	}
}
