package com.prep2020.easy;

public class Problem1582 {
	public int numSpecial(int[][] mat) {
		int m = mat.length, n = mat[0].length;
        boolean[] row = new boolean[m], col = new boolean[n];
        for (int i = 0; i < m; i++) {
        	int count = 0;
        	for (int j = 0; j < n; j++) {
        		if (mat[i][j] == 1) {
        			count++;
        			if (count > 1) {
        				break;
        			}
        		}
        	}
        	if (count == 1) row[i] = true;
        }
        for (int i = 0; i < n; i++) {
        	int count = 0;
        	for (int j = 0; j < m; j++) {
        		if (mat[j][i] == 1) {
        			count++;
        			if (count > 1) {
        				break;
        			}
        		}
        	}
        	if (count == 1) col[i] = true;
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
        	if (!row[i]) continue;
        	for (int j = 0; j < n; j++) {
        		if (mat[i][j] == 1 && col[j]) {
        			result++;
        			break;
        		}
        	}
        }
        return result;
    }
}
