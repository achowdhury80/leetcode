package com.prep2020.medium;

import java.util.Arrays;

public class Problem518 {
	/**
	 * O(amount * coins.length) time and o(amount) space
	 * @param amount
	 * @param coins
	 * @return
	 */
	public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
        	for (int j = 1; j <= amount; j++) {
        		if (j < coin) continue;
        		dp[j] += dp[j - coin];
        	}
        }
        return dp[amount];
    }
}
