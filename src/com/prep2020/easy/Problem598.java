package com.prep2020.easy;

public class Problem598 {
	/**
	 * O(N)
	 * @param m
	 * @param n
	 * @param ops
	 * @return
	 */
	public int maxCount(int m, int n, int[][] ops) {
		int row = m, col = n;
		for (int i = 0; i < ops.length; i++) {
			row = Math.min(row, ops[i][0]);
			col = Math.min(col, ops[i][1]);
		}
        return row * col;
    }
}
