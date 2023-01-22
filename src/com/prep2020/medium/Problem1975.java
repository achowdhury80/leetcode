package com.prep2020.medium;

public class Problem1975 {
	/**
	 * O(m * n)
	 * @param matrix
	 * @return
	 */
	public long maxMatrixSum(int[][] matrix) {
		long sum = 0;
		int min = Integer.MAX_VALUE, negCount = 0;
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		sum += Math.abs(matrix[i][j]);
        		min = Math.min(min, Math.abs(matrix[i][j]));
        		if (matrix[i][j] < 0) negCount++;
        	}
        }
        if (negCount % 2 == 1) {
        	sum -= 2 * min;
        }
        return sum;
    }
}
