package com.prep2020.medium.more2000;

public class Problem2128 {
	/**
	 * O(m * n) time 
	 * and o(n) space
	 * @param grid
	 * @return
	 */
	public boolean removeOnes(int[][] grid) {
        int n = grid[0].length;
        boolean[] arr = new boolean[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = grid[0][i] == grid[0][0];
        }
        for (int i = 1; i < grid.length; i++) {
        	for (int j = 0; j < n; j++) {
        		if (arr[j] != (grid[i][j] == grid[i][0])) return false;
        	}
        }
        return true;
    }
}
