package com.prep2020.easy;

public class Problem867 {
	/**
	 * O(m * n)
	 * @param A
	 * @return
	 */
	public int[][] transpose(int[][] A) {
		int m = A.length, n = A[0].length;
		int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		result[j][i] = A[i][j];
        	}
        }
        return result;
    }
}
