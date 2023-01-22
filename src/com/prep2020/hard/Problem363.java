package com.prep2020.hard;
import java.util.*;
public class Problem363 {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int m = matrix.length, n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				matrix[i][j] += matrix[i][j - 1];
			}
		}
		int result = Integer.MIN_VALUE;
		for (int c2 = 0; c2 < n; c2++) {
			for (int c1 = 0; c1 <= c2; c1++) {
				TreeSet<Integer> treeSet = new TreeSet<>();
				treeSet.add(0);
				int sum = 0;
				for (int i = 0; i < m; i++) {
					int curSum = matrix[i][c2] - (c1 == 0 ? 0 : matrix[i][c1 - 1]);
					sum += curSum;
					int gap = sum - k;
					Integer ceilVal = treeSet.ceiling(gap);
					if (ceilVal != null) result = Math.max(result, sum - ceilVal);
					treeSet.add(sum);
				}
			}
		}
		return result;
    }
}
