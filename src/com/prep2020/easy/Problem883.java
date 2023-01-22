package com.prep2020.easy;

public class Problem883 {
	/**
	 * O(M * N)
	 * @param grid
	 * @return
	 */
	public int projectionArea(int[][] grid) {
		int count = 0;
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			int rowMax = 0;
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] > 0) {
					count++;
					rowMax = Math.max(rowMax, grid[i][j]);
				}
			}
			result += rowMax;
		}
		result += count;
		for (int j = 0; j < grid[0].length; j++) {
			int colMax = 0;
			for (int i = 0; i < grid.length; i++) {
				if (grid[i][j] > 0) {
					colMax = Math.max(colMax, grid[i][j]);
				}
			}
			result += colMax;
		}
        return result;
    }
}
