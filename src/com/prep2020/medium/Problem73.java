package com.prep2020.medium;

public class Problem73 {
	/**
	 * O(M * N)
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int firstRow = 1;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == 0) {
        			matrix[0][j] = 0;
        			if (i == 0) firstRow = 0;
        			else matrix[i][0] = 0;
        		}
        	}
        }
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		if (matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
        	}
        }
        if (matrix[0][0] == 0) {
        	for (int i = 1; i < m; i++) matrix[i][0] = 0;
        }
        if (firstRow == 0) {
        	for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
    }
	
	public static void main(String[] args) {
		Problem73 problem = new Problem73();
		int[][] mat = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		problem.setZeroes(mat);
		System.out.println(mat);
	}
}
