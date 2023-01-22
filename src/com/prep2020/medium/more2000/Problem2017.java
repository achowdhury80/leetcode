package com.prep2020.medium.more2000;

public class Problem2017 {
	/**
	 * O(N)
	 * @param grid
	 * @return
	 */
	public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long upSum = 0, downSum = 0;
        for (int i = 0; i < n; i++) upSum += grid[0][i];
        long result = -1;
        for (int i = 0; i < n; i++) {
        	if (i > 0) downSum += grid[1][i - 1];
        	upSum -= grid[0][i];
        	long max = Math.max(upSum, downSum);
        	if (result == -1 || result > max) result = max;
        }
        return result;
    }
}
