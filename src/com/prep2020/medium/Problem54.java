package com.prep2020.medium;
import java.util.*;
public class Problem54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] start = new int[] {0, 0};
        while(m > 0 && n > 0) {
        	collect(matrix, new int[] {start[0], start[1]}, m, n, result);
        	m -= 2;
        	n -= 2;
        	start[0]++;
        	start[1]++;
        }
        return result;
    }

	private void collect(int[][] matrix, int[] start, int m, int n, List<Integer> result) {
		if (n == 1) {
			for (int i = 0; i < m; i++) {
				result.add(matrix[start[0] + i][start[1]]);
			}
			return;
		}
		if (m == 1) {
			for (int i = 0; i < n; i++) {
				result.add(matrix[start[0]][start[1] + i]);
			}
			return;
		}
		for (int i = 0; i < n - 1; i++) result.add(matrix[start[0]][start[1] + i]);
		for (int i = 0; i < m - 1; i++) result.add(matrix[start[0] + i][start[1] + n - 1]);
		for (int i = 0; i < n - 1; i++) result.add(matrix[start[0] + m - 1][start[1] + n - 1 - i]);
		for (int i = 0; i < m - 1; i++) result.add(matrix[start[0] + m - 1 - i][start[1]]);
	}
	
	public static void main(String[] args) {
		Problem54 problem = new Problem54();
		System.out.println(problem.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
	}
}
