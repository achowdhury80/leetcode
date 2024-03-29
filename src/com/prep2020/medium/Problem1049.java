package com.prep2020.medium;

public class Problem1049 {
	/**
	 * dp[i][s] is whether s sum can be achieved using some of first i elements
	 * we try to find closest sum of total sum / 2.
	 * The idea is to partition the array into two parts with sum of each subsets as close to totalSum/2 to minimize the difference. Also we need to only go till sum/2 as the sum of the other subset will be totalSum - sum of subset1. Then we just see which is the closest sum possible of subset1 and return totalSum-2*possibleSum
	 * @param stones
	 * @return
	 */
	public int lastStoneWeightII(int[] stones) {
		int n = stones.length;
		int sum = 0;
		for (int s : stones) sum += s;
		int target = sum / 2, result = 0;
        boolean[][] dp = new boolean[target + 1][n + 1];
        for (int i = 0; i < n + 1; i++) dp[0][i] = true;
        for (int i = 1; i <= target; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (dp[i][j - 1] || i >= stones[j - 1] && dp[i - stones[j -1]][j - 1]) {
        			dp[i][j] = true;
        			result = Math.max(result, i);
        		}
        	}
        }
        return sum - 2 * result;
    }
}
