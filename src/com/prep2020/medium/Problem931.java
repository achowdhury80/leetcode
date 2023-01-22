package com.prep2020.medium;

public class Problem931 {
	/**
	 * O(m * n)
	 * @param matrix
	 * @return
	 */
	public int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int min = matrix[i][j] + matrix[i - 1][j];
				if (j > 0) min = Math.min(min, matrix[i][j] + matrix[i - 1][j - 1]);
				if (j < matrix[0].length - 1) 
					min = Math.min(min, matrix[i][j] + matrix[i - 1][j + 1]);
				matrix[i][j] = min;
			}
		}
		int result = matrix[n - 1][0];
        for (int i = 1; i < matrix[0].length; i++) result = Math.min(result, matrix[n - 1][i]);
        return result;
    }
}
