package com.prep2020.easy;

public class Problem661 {
	/**
	 * O(MN)
	 * @param M
	 * @return
	 */
	public int[][] imageSmoother(int[][] M) {
        for (int i = 0; i < M.length; i++) {
        	for (int j = 0; j < M[0].length; j++) {
        		int avg = findAvg(M, i, j);
        		M[i][j] |= (avg << 8);
        	}
        }
        for (int i = 0; i < M.length; i++) {
        	for (int j = 0; j < M[0].length; j++) {
        		M[i][j] >>= 8;
        	}
        }
        return M;
    }
	
	private int findAvg(int[][] M, int x, int y) {
		int sum = 0, count = 0, m = M.length, n = M[0].length;
		for (int i = x - 1; i < x + 2; i++) {
			if (i < 0 || i == m) continue;
			for (int j = y - 1; j < y + 2; j++) {
				if (j < 0 || j == n) continue;
				sum += M[i][j] & ((1 << 8) - 1);
				count++;
			}
		}
		return sum /count;
	}
}
