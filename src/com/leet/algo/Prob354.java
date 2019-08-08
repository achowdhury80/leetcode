package com.leet.algo;

import java.util.Arrays;

public class Prob354 {
	/**
	 * o(n^2) and o(n ^2)
	 * first sort, then dp
	 * sort is tricky. sort on x[0] < y[0] and if equal then x[1] - y[1]
	 * @param envelopes
	 * @return
	 */
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes.length < 1) return 0;
        Arrays.sort(envelopes, (x, y) -> (x[0] - y[0] == 0) ? x[1] - y[1] : x[0] - y[0]);
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < envelopes.length; i++) {
        	dp[i] = 1;
        	for (int j = i - 1; j > -1; j--) {
        		if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        		}
        	}
        	result = Math.max(result, dp[i]);
        }
        return result;
    }
}
