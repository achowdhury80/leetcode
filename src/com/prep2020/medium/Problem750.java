package com.prep2020.medium;

public class Problem750 {
	/**
	 * O(m^2 * n)
	 * @param grid
	 * @return
	 */
	public int countCornerRectangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m - 1; i++) {
        	for (int j = i + 1; j < m; j++) {
        		int match = 0;
        		for (int k = 0; k < n; k++) {
        			if (grid[i][k] == 1 && grid[j][k] == 1) match++;
        		}
        		result += match * (match - 1) / 2;
        	}
        }
        return result;
    }
}
