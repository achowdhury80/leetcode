package com.leet.algo;

public class Prob892 {
	 public int surfaceArea(int[][] grid) {
		 int result = 0;
		 for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid.length; j++) {
        		if (grid[i][j] > 0) {
        			result += surfacePerTower(grid, i, j);
        		}
        	}
        }
        
        return result;
	 }
	 
	 private int surfacePerTower(int[][] grid, int i, int j) {
		 if (grid[i][j] == 0) return 0;
		 int result = 2;
		 if (i == 0 || grid[i - 1][j] == 0) result += grid[i][j];
		 else {
			 if (grid[i][j] > grid[i - 1][j]) result += grid[i][j] - grid[i - 1][j];
		 }
		 if (i + 1 == grid.length || grid[i + 1][j] == 0) result += grid[i][j];
		 else {
			 if (grid[i][j] > grid[i + 1][j]) result += grid[i][j] - grid[i + 1][j];
		 }
		 if (j == 0 || grid[i][j - 1] == 0) result += grid[i][j];
		 else {
			 if (grid[i][j] > grid[i][j - 1]) result += grid[i][j] - grid[i][j - 1];
		 }
		 if (j + 1 == grid.length || grid[i][j + 1] == 0) result += grid[i][j];
		 else {
			 if (grid[i][j] > grid[i][j + 1]) result += grid[i][j] - grid[i][j + 1];
		 }
		 
		 return result;
	 }
}
