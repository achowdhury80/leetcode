package com.prep2020.hard;
import java.util.*;
public class Problem2218 {
	public int maxValueOfCoins(List<List<Integer>> piles, int k) {
		int n = piles.size();
        int[][] dp = new int[n][k + 1];
        for (int i = 1; i <= k; i++) {
        	for (int j = 0; j < n; j++) {
        		dp[j][i] = j > 0 ? dp[j - 1][i] : 0;
        		int sum = 0;
        		for (int x = 1; x <= Math.min(i, piles.get(j).size()); x++) {
        			sum += piles.get(j).get(x - 1);
        			dp[j][i] = Math.max(dp[j][i], sum + (j > 0 ? dp[j - 1][i - x] : 0));
        		}
        	}
        }
        return dp[n - 1][k];
    }
}
