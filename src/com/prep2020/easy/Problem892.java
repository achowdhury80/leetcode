package com.prep2020.easy;

public class Problem892 {
	public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] > 0) result += 2;
        		result += (i == 0 ? grid[i][j] : Math.max(0, grid[i][j] - grid[i - 1][j]));
        		result += (i == n - 1 ? grid[i][j] : Math.max(0, grid[i][j] - grid[i + 1][j]));
        		result += (j == 0 ? grid[i][j] : Math.max(0, grid[i][j] - grid[i][j - 1]));
        		result += (j == n - 1 ? grid[i][j] : Math.max(0, grid[i][j] - grid[i][j + 1]));
        	}
        }
        return result;
    }
}
