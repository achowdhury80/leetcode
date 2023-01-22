package com.prep2020.easy;

public class Problem1572 {
	/**
	 * O(N)
	 * @param mat
	 * @return
	 */
	public int diagonalSum(int[][] mat) {
        int n;
        if ((n = mat.length) < 1) return 0; 
        int result = 0;
        for (int i = 0; i < n; i++) result += mat[i][i];
        if (n % 2 == 1) result -= mat[n / 2][n /2];
        for (int i = 0; i < n; i++) result += mat[i][n - i - 1];
        return result;
    }
}
