package com.prep2020.medium;

public class Problem650 {
	/**
	 * O(N^2) time and O(N) space
	 * @param n
	 * @return
	 */
	public int minSteps(int n) {
        if (n < 2) return 0;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) dp[i] = Integer.MAX_VALUE;
        for (int i = 2; i <= n; i++) {
        	for (int j = 1; j <= (i / 2); j++) {
        		if (i % j != 0) continue;
        		dp[i] = Math.min(dp[i], dp[j] + (i / j));
        	}
        }
        return dp[n];
    }
	
	public static void main(String[] args) {
		Problem650 problem = new Problem650();
		System.out.println(problem.minSteps(3));
	}
}
