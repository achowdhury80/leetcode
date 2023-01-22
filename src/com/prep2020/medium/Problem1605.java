package com.prep2020.medium;

public class Problem1605 {
	/**
	 * O(m * n)
	 * @param rowSum
	 * @param colSum
	 * @return
	 */
	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
		int m = rowSum.length, n = colSum.length;
        int[][] result = new int[m][n];
        int[] curColSum = new int[n];
        for (int i = 0; i < m; i++) {
        	int curRowSum = 0;
        	for (int j = 0; j < n; j++) {
        		result[i][j] = Math.min(rowSum[i] - curRowSum, colSum[j] - curColSum[j]);
        		curRowSum += result[i][j];
        		curColSum[j] += result[i][j];
        	}
        }
        return result;
    }
}
