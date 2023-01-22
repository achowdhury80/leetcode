package com.prep2020.easy;
import java.util.*;
public class Problem1380 {
	/**
	 * O(m * n)
	 * @param matrix
	 * @return
	 */
	public List<Integer> luckyNumbers (int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int row0Min = matrix[0][0];
        for (int i = 1; i < n; i++) {
        	row0Min = Math.min(row0Min, matrix[0][i]);
        }
        for (int i = 0; i < n; i++) {
        	for (int j = 1; j < m; j++) {
        		matrix[0][i] = Math.max(matrix[0][i], matrix[j][i]);
        		matrix[j][0] = Math.min(matrix[j][0], matrix[j][i]);
        	}
        }
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (((i == 0 && matrix[i][j] == row0Min) 
        				|| (i > 0 && matrix[i][j] == matrix[i][0])) 
        				&& matrix[i][j] == matrix[0][j]) 
        				result.add(matrix[i][j]);
        	}
        }
        return result;
    }
}
