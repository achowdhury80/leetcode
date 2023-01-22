package com.prep2020.medium;

public class Problem322 {
	/**
	 * O(amount *n) time
	 * O(amount) space
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i >= coin) {
					if (dp[i - coin] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
				}
			}
		}
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
