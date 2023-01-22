package com.prep2020.medium;

public class Problem1884 {
	public int twoEggDrop(int n) {
		if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	dp[i] = Integer.MAX_VALUE;
        	for (int j = i - 1; j > 0; j--) {
        		dp[i] = Math.min(dp[i], Math.max(1 + dp[i - j], j));
        	}
        }
        return dp[n];
    }
}
