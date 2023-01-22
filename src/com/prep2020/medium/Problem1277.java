package com.prep2020.medium;

public class Problem1277 {
	/**
	 * O(m * n)
	 * @param matrix
	 * @return
	 */
	public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == 1) {
        			result++;
        			for (int k = 1; i - k >= 0 && j - k >= 0; k++) {
        				if (matrix[i - k][j] >= 1 && matrix[i][j - k] >= 1
        						&& matrix[i - 1][j - 1] >= k) {
        					result++;
        					matrix[i][j] = k + 1;
        				} else break;
        			}
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1277 problem = new Problem1277();
		System.out.println(problem.countSquares(new int[][] {
			{0,1,1,1},
			{1,1,1,1},
            {0,1,1,1}
		}));
	}
}
