package com.prep2020.medium;
import java.util.*;
public class Problem1072 {
	/**
	 * O(m * N) time and space
	 * @param matrix
	 * @return
	 */
	public int maxEqualRowsAfterFlips(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int result = 0;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			int subtract = 0;
			if (matrix[i][0] == 1) subtract = 1;
			String s = "";
			for (int j = 0; j  < n; j++) s += Math.abs(matrix[i][j] - subtract);
			int count = 0;
			map.put(s, (count = map.getOrDefault(s, 0) + 1));
			result = Math.max(result, count);
		}
		return result;
    }
}
