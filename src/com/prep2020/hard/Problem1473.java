package com.prep2020.hard;

public class Problem1473 {
	public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][target + 1][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j <= target; j++) {
        		for (int k = 0; k < n; k++) dp[i][j][k] = Integer.MAX_VALUE;
        	}
        }
        
        for (int i = 0; i < m; i++) {
        	for (int j = 1; j <= target; j++) {
        		if (j > i + 1) break;
        		for (int k = 0; k < n; k++) {
        			if (houses[i] != 0 && houses[i] != k + 1) continue;
        			int costForThisHouse = 0;
        			if (houses[i] == 0) costForThisHouse = cost[i][k];
        			if (i == 0) {
        				dp[i][j][k] = costForThisHouse;
        				continue;
        			}
        			int costForTillLastHouseWithSeparateColor = Integer.MAX_VALUE;
        			for (int x = 0; x < n; x++) {
        				if (x == k) continue;
        				costForTillLastHouseWithSeparateColor = Math.min(costForTillLastHouseWithSeparateColor, dp[i - 1][j - 1][x]);
        			}
        			
        			dp[i][j][k] = Math.min(dp[i - 1][j][k] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (dp[i - 1][j][k] + costForThisHouse), 
        					costForTillLastHouseWithSeparateColor == Integer.MAX_VALUE ? Integer.MAX_VALUE : (costForTillLastHouseWithSeparateColor + costForThisHouse));
        		}
        	}
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
        	result = Math.min(result, dp[m - 1][target][i]);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
	
	public static void main(String[] args) {
		Problem1473 problem = new Problem1473();
		System.out.println(problem.minCost(new int[] {0, 2, 1, 2, 0}, new int[][] {{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3));
	}
}
