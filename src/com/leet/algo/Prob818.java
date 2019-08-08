package com.leet.algo;

import java.util.Arrays;

public class Prob818 {
	/**
	 * dp[i] number of steps to reach i distance
	 * https://leetcode.com/problems/race-car/solution/
	 * @param target
	 * @return
	 */
	public int racecar(int target) {
		if (target < 2) return target;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 4;
        for (int t = 3; t < target + 1; t++) {
        	int k = 1;
        	while((1 << k) - 1 < t) {
        		k++;
        	}
        	if ((1 << k) - 1 == t) {
        		dp[t] = k;
        		continue;
        	} 
        	for (int j = 0; j < k -1; j++) {
        		dp[t] = Math.min(dp[t], k - 1 + j + 2 + dp[t - ((1 << (k - 1)) - 1) + (1 << j) - 1 ]);
        	}
        	if ((1 << k) - 1 - t < t) {
        		dp[t] = Math.min(dp[t], k + 1 + dp[(1 << k) - 1 - t]);
        	}
        }
        return dp[target];
    }
}
