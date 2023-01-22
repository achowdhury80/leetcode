package com.prep2020.hard;
import java.util.*;
public class Problem1278 {
	public int palindromePartition(String s, int k) {
		int n = s.length();
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j <= k; j++) dp[i][j] = Integer.MAX_VALUE;
        }
        find(s, 0, k, dp, new HashMap<>());
        return dp[0][k];
    }

	private int find(String s, int start, int k, int[][] dp, Map<Integer, Integer> cache) {
		if (dp[start][k] != Integer.MAX_VALUE) return dp[start][k];
		int n = s.length();
		if (k == 1) {
			dp[start][k] = findChangeCount(s, start, s.length() - 1, cache);
			return dp[start][k];
		}
		for (int i = start; i < n - (k - 1); i++) {
			int firstPart = findChangeCount(s, start, i, cache);
			int laterPart = find(s, i + 1, k - 1, dp, cache);
			dp[start][k] = Math.min(dp[start][k], firstPart + laterPart);
		}
		return dp[start][k];
	}

	private int findChangeCount(String s, int start, int end, Map<Integer, Integer> cache) {
		if (start == end) return 0;
		int key = (start << 7) | end;
		if (cache.containsKey(key)) return cache.get(key);
		return (s.charAt(start) == s.charAt(end) ? 0 : 1) + (start + 1 == end ? 0 : (findChangeCount(s, start + 1, end - 1, cache)));
	}
}
