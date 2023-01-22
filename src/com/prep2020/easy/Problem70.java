package com.prep2020.easy;

public class Problem70 {
	/**
	 * O(N) time
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if (n < 3) return n;
        int[] dp = new int[] {1, 2};
        for (int i = 3; i <= n; i++) {
        	int temp = dp[0] + dp[1];
        	dp[0] = dp[1];
        	dp[1] = temp;
        }
        return dp[1];
    }
}
