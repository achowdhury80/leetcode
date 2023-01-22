package com.prep2020.hard;

public class Problem1463 {
	public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		dp[i][j] = -1;
        	}
        }
        dp[0][n - 1] = grid[0][0] + grid[0][n - 1];
        for (int i = 1; i < m; i++) {
        	int[][] temp = new int[n][n];
        	for (int x = 0; x < n; x++) {
            	for (int j = 0; j < n; j++) {
            		temp[x][j] = -1;
            	}
            }
        	for (int j = 0; j < n; j++) {
        		for (int x = -1; x < 2; x++) {
        			int prev1 = j + x;
        			if (prev1 < 0 || prev1 == n) continue;
        			for (int k = 0; k < n; k++) {
        				for (int y = -1; y < 2; y++) {
        					int prev2 = k + y;
            				if (prev2 < 0 || prev2 == n) continue;
            				if (dp[prev1][prev2] > -1) {
            					temp[j][k] = Math.max(temp[j][k], grid[i][j] + (j == k ? 0 : grid[i][k]) + dp[prev1][prev2]);
            				}
        				}
        			}
        		}	
        	}
        	dp = temp;
        	
        }
        
        int result = 0;
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) result = Math.max(result, dp[i][j]);
    	}
    	return result;
    }
	
	public static void main(String[] args) {
		Problem1463 problem = new Problem1463();
		System.out.println(problem.cherryPickup(new int[][]{{3,1,1},{2,5,1},{1,5,5},{2,1,1}}));
	}
}
