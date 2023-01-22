package com.prep2020.easy;

public class Problem1351 {
	/**
	 * O(m + n)
	 * Start from bottom-left corner of the matrix, count in the negative numbers in each row.
	 * @param grid
	 * @return
	 */
	public int countNegatives(int[][] grid) {
        int m, n;
        if ((m = grid.length) < 1 || (n = grid[0].length) < 1) return 0;
        int result = 0;
        int[] cur = new int[] {m - 1, 0};
        while(cur[0] > -1 && cur[1] < n) {
        	if (grid[cur[0]][cur[1]] < 0) {
        		result += (n - cur[1]);
        		cur[0]--;
        	} else {
        		cur[1]++;
        	}
        }
        return result;
    }
}
