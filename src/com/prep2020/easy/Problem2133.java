package com.prep2020.easy;

public class Problem2133 {
	public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
        	boolean[] usedForRow = new boolean[n + 1], 
        			usedForCol = new boolean[n + 1];
        	for (int j = 0; j < n; j++) {
        		if (usedForRow[matrix[i][j]]) return false;
        		usedForRow[matrix[i][j]] = true;
        		if (usedForCol[matrix[j][i]]) return false;
        		usedForCol[matrix[j][i]] = true;
        	}
        }
        return true;
    }
}
