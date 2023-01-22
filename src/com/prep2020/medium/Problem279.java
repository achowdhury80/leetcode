package com.prep2020.medium;

public class Problem279 {
	/**
	 * O(N^(3/2)) and O(N) space
	 * @param n
	 * @return
	 */
	public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = Integer.MAX_VALUE;
        for (int i = 2; i <= n; i++) {
        	for (int j = 1; j * j <= i; j++) {
        		if (j * j == i) {
        			dp[i] = 1;
        			break;
        		}
        		dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
        	}
        }
        return dp[n];
    }
	
	public static void main(String[] args) {
		Problem279 problem = new Problem279();
		System.out.println(problem.numSquares(12));
	}
}
