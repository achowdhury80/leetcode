package com.prep2020.medium;

public class Problem221 {
	/**
	 * O(m*n)
	 * @param matrix
	 * @return
	 */
	public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][][] arr = new int[m][n][3];
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == '1') {
        			arr[i][j] = new int[] {1, 1, 1};
        			if (j > 0) arr[i][j][0] += arr[i][j - 1][0];
        			if (i > 0) arr[i][j][1] += arr[i - 1][j][1];
        			if (i > 0 && j > 0) {
        				arr[i][j][2] = Math.min(arr[i - 1][j - 1][2] + 1, 
        						Math.min(arr[i][j][0], arr[i][j][1]));
        			}
        			result = Math.max(result, arr[i][j][2]);
        		}
        	}
        }
        return result * result;
    }
	
	public static void main(String[] args) {
		Problem221 problem = new Problem221();
		System.out.println(problem.maximalSquare(new char[][]{{'1','0','1','0','0'},
			{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
	}
}
