package com.prep2020.hard;
import java.util.*;
public class Problem956 {
	public int tallestBillboard(int[] rods) {
		int n = rods.length;
		int sum = 0;
        for (int r :rods) sum += r;
        // dp[i][j] = Max of min heights with difference j, considering till ith bar
		int[][] dp = new int[n + 1][sum + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) dp[i][j] = -1;
		}
		dp[0][0] = 0;
		for (int i = 1; i <= n; i++) {
			int h = rods[i - 1];
			for (int j = 0; j <= sum - h; j++) {
				if (dp[i - 1][j] < 0) continue;
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
				dp[i][j + h] = Math.max(dp[i][j + h], dp[i - 1][j]);
				dp[i][Math.abs(j - h)] = Math.max(dp[i][Math.abs(j - h)], dp[i - 1][j] + Math.min(h, j));
			}
		}
		return dp[n][0];
	}
	public int tallestBillboard1(int[] rods) {
        int sum = 0;
        for (int r :rods) sum += r;
        return helper(rods, 0, 0, 0, sum / 2,new HashMap<>());
    }

	private int helper(int[] rods, int start, int sum1, int sum2, int max, Map<Integer, Integer> cache) {
		int key = (sum1 << 18) | (sum2 << 5) | start;
		if (cache.containsKey(key)) return cache.get(key);
		int result = 0;
		if (sum1 == sum2) {
			result = sum1;
		}
		if (start != rods.length) {
			int r1 = 0, r2 = 0, r3 = 0;
			if (sum1 + rods[start] <= max) {
				r1 = helper(rods, start + 1, sum1 + rods[start], sum2, max, cache);
			}
			if (sum2 + rods[start] <= max) {
				r2 = helper(rods, start + 1, sum1, sum2 + rods[start], max, cache);
			}
			r3 = helper(rods, start + 1, sum1, sum2, max, cache);
			result = Math.max(result, Math.max(r1, Math.max(r2, r3)));
		}
		cache.put(key, result);
		return cache.get(key);
	}
}
