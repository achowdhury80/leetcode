package com.prep2020.easy;

public class Problem832 {
	/**
	 * O(m * n)
	 * @param A
	 * @return
	 */
	public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
        	int j = 0, k = n - 1;
        	while(j < k) {
        		if (A[i][j] == A[i][k]) {
        			A[i][j] ^= 1;
        			A[i][k] ^= 1;
        		}
        		j++;
        		k--;
        	}
        	if (j == k) A[i][j] ^= 1;
        }
        return A;
    }
}
