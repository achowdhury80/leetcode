package com.prep2020.medium;

public class Problem240 {
	/**
	 * O(m + n)
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[] cur = new int[] {0, n - 1};
        while(true) {
        	if (matrix[cur[0]][cur[1]] == target) return true;
        	if (matrix[cur[0]][cur[1]] > target) {
        		if (cur[1] == 0) return false;
        		cur[1]--;
        	} else {
        		if (cur[0] == m - 1) return false;
        		cur[0]++;
        	}
        }
    }
}
