package com.prep2020.medium;

public class Problem62 {
	/**
	 * O(m * n) time and O(N) space
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		if (m == 1 || n == 1) return 1;
		if (n > m) return uniquePaths(n, m);
		int[] lastRow = new int[n];
        for (int i = 0; i < n; i++) lastRow[i] = 1;
        for (int i = 1; i < m; i++) {
        	int[] temp = new int[n];
        	temp[0] = 1;
        	for (int j = 1; j < n; j++) temp[j] = lastRow[j] + temp[j - 1];
        	lastRow = temp;
        }
        return lastRow[n - 1];
    }
}
