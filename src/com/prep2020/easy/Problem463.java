package com.prep2020.easy;

public class Problem463 {
	/**
	 * O(M * N)
	 * @param grid
	 * @return
	 */
	public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			if (i == 0 || grid[i - 1][j] == 0) result++;
        			if (i == m - 1 || grid[i + 1][j] == 0) result++;
        			if (j == 0 || grid[i][j - 1] == 0) result++;
        			if (j == n - 1 || grid[i][j + 1] == 0) result++;
        		}
        	}
        }
        return result;
    }
}
