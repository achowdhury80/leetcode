package com.leet.algo;

public class Prob883 {
	public int projectionArea(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
        	int rowMax = 0;
        	for (int j = 0; j < grid.length; j++) {
        		if (grid[i][j] > 0) {
        			result++;
        			grid[0][j] = Math.max(grid[0][j], grid[i][j]);
        			rowMax = Math.max(rowMax, grid[i][j]);
        		}
        	}
        	result += rowMax;
        }
        for (int i = 0; i < grid.length; i++) {
        	result += grid[0][i];
        }
        return result;
    }
}
