package com.prep2020.easy;

public class Problem566 {
	/**
	 * O(m * n)
	 * @param nums
	 * @param r
	 * @param c
	 * @return
	 */
	public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) return nums;
        int[][] result = new int[r][c];
        int x = 0, y = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		result[x][y] = nums[i][j];
        		if (y == c - 1) {
        			y = 0;
        			x++;
        		} else y++;
        	}
        }
        return result;
    }
}
