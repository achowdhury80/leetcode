package com.prep2020.medium;

public class Problem96 {
	/**
	 * O(N^2) time and O(N) space
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[0] = 1;
		for (int i = 2; i <= n; i++) {
			// we can optimize further but not complexity improvement
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
        return dp[n];
    }
}
