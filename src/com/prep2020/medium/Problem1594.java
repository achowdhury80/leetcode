package com.prep2020.medium;

public class Problem1594 {
	public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m][n][2];
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		dp[i][j][0] = Integer.MIN_VALUE - 1l;
        		dp[i][j][1] = Integer.MAX_VALUE + 1l;
        	}
        }
        
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        for (int i = 1; i < n; i++) {
        	dp[0][i][0] = dp[0][i - 1][0] * grid[0][i];
        	dp[0][i][1] = dp[0][i][0];
        }
        for (int i = 1; i < m; i++) {
        	dp[i][0][0] = dp[i - 1][0][0] * grid[i][0];
        	dp[i][0][1] = dp[i][0][0];
        }
        
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		long maxValFromNeighbor = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]), minValFromNeighbor = Math.min(dp[i - 1][j][1], dp[i][j - 1][1]);
        		if (grid[i][j] >= 0) {
        			dp[i][j][0] = grid[i][j] * maxValFromNeighbor;
        			dp[i][j][1] = grid[i][j] * minValFromNeighbor;
        		} else {
        			dp[i][j][1] = grid[i][j] * maxValFromNeighbor;
        			dp[i][j][0] = grid[i][j] * minValFromNeighbor;
        		}
        	}
        }
        return dp[m - 1][n - 1][0] < 0 ? -1 : (int)(dp[m - 1][n - 1][0] % (long)(1e9 + 7));
    }
	
	public static void main(String[] args) {
		Problem1594 problem = new Problem1594();
		System.out.println(problem.maxProductPath(new int[][]{{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}}));
	}
}
