package com.prep2020.hard;
import java.util.*;
public class Problem1074 {
	public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		matrix[i][j] += matrix[i][j - 1];
        	}
        }
        int result = 0;
        for (int c1 = 0; c1 < n; c1++) {
        	for (int c2 = c1; c2 < n; c2++) {
        		Map<Integer, Integer> map = new HashMap<>();
        		map.put(0, 1);
        		int curSum = 0;
        		for (int r = 0; r < m; r++) {
        			curSum += matrix[r][c2] - (c1 > 0 ? matrix[r][c1 - 1]: 0);
        			result += map.getOrDefault(curSum - target, 0);
        			map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        		}
        	}
        } 
        return result;
    }
}
