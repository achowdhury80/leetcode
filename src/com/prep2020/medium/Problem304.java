package com.prep2020.medium;

public class Problem304 {
	private int[][] m;
	public Problem304(int[][] matrix) {
        this.m = matrix;
        for (int i = 1; i < m[0].length; i++) m[0][i] = m[0][i - 1] + m[0][i];
        for (int i = 1; i < m.length; i++) m[i][0] = m[i - 1][0] + m[i][0];
        for (int i = 1; i < m.length; i++) {
        	for (int j = 1; j < m[0].length; j++) {
        		m[i][j] += m[i - 1][j] + m[i][j - 1] - findCommonRegionSum(i - 1, j, i, j - 1);
        	}
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	int result = m[row2][col2];
        if (row1 == 0 && col1 == 0) return result;
    	if (row1 == 0) return result - m[row2][col1 - 1];
    	if (col1 == 0) return result - m[row1 - 1][col2];
    	return result - m[row2][col1 - 1] - m[row1 - 1][col2] + m[row1 - 1][col1 - 1];
        
    }
    
    private int findCommonRegionSum(int r1, int c1, int r2, int c2) {
    	int r = Math.min(r1, r2), c = Math.min(c1, c2);
    	return m[r][c];
    }
}
