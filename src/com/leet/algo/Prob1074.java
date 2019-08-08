package com.leet.algo;

import java.util.*;
public class Prob1074 {
	/*
	 * For each row, calculate the prefix sum.
For each pair of columns,
calculate the accumulated sum of rows.
Now this problem is same to, "Find the Subarray with Target Sum".
	 */
	public int numSubmatrixSumTarget(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
        	for (int j = 1; j < n; j++) matrix[i][j] += matrix[i][j - 1];
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = i; j < n; j++) {
        		Map<Integer, Integer> map = new HashMap<>();
        		map.put(0, 1);
        		int cur = 0;
        		for (int k = 0; k < m; k++) {
        			cur += matrix[k][j] - (i == 0 ? 0 : matrix[k][i - 1]);
        			result += map.getOrDefault(cur - target, 0);
        			map.put(cur, map.getOrDefault(cur, 0) + 1);
        		}
        	}
        }
        return result;
    }
}
