package com.prep2020.medium;

public class Problem562 {
	/**
	 * O(m * n) time and O(n) space
	 * @param mat
	 * @return
	 */
	public int longestLine(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // 0 horizontal, 1 vertical, 2 diagonal, 3 anti-diagonal
        int[][] last = new int[n][4]; 
        int result = 0;
        for (int i = 0; i < m; i++) {
        	int[][] temp = new int[n][4]; 
        	for (int j = 0; j < n; j++) {
        		if (mat[i][j] == 0) continue;
        		temp[j] = new int[] {1, 1, 1, 1};
        		if (j > 0) {
        			temp[j][0] += temp[j - 1][0];
        			temp[j][2] += last[j - 1][2];
        		}
        		temp[j][1] += last[j][1];
        		if (j + 1 < n) temp[j][3] += last[j + 1][3];
        		result = Math.max(result, Math.max(Math.max(temp[j][0], 
        				temp[j][1]), Math.max(temp[j][2], temp[j][3])));
        	}
        	last = temp;
        }
        return result;
    }
}
