package com.prep2020.medium.more2000;

public class Problem2304 {
	public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[] row = grid[0];
        for (int i = 1; i < m; i++) {
        	int[] temp = new int[n];
        	for (int j = 0; j < n; j++) temp[j] = Integer.MAX_VALUE;
        	for (int j = 0; j < n; j++) {
        		for (int k = 0; k < n; k++) {
        			temp[k] = Math.min(temp[k], grid[i][k] + moveCost[grid[i - 1][j]][k] + row[j]);
        		}
        	}
        	row = temp;
        }
        int result = Integer.MAX_VALUE;
        for (int i : row) result = Math.min(result, i);
        return result;
    }
}
