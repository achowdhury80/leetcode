package com.prep2020.easy;

public class Problem2022 {
	/**
	 * O(m * n)
	 * @param original
	 * @param m
	 * @param n
	 * @return
	 */
	public int[][] construct2DArray(int[] original, int m, int n) {
        int x = original.length;
        if (m * n != x) return new int[0][];
        int[][] result = new int[m][n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) result[i][j] = original[idx++];
        }
        return result;
    }
}
