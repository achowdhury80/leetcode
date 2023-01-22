package com.prep2020.medium;

import java.util.Arrays;

public class Problem1626 {
	public int bestTeamScore(int[] scores, int[] ages) {
		int n = scores.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        Arrays.sort(arr, (x, y) -> ages[x] == ages[y] ? (scores[x] - scores[y]) : (ages[x] - ages[y]));
        int[] dp = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
        	int score = scores[arr[i]];
        	dp[i] = score;
        	for (int j = i - 1; j > -1; j--) {
        		if (scores[arr[i]] >= scores[arr[j]]) dp[i] = Math.max(dp[i], score + dp[j]);
        	}
        	result = Math.max(result, dp[i]);
        }
        return result;
    }
}
