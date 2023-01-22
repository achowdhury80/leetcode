package com.prep2020.medium;

public class Problem647 {
	/**
	 * O(N^2) time and space
	 * @param s
	 * @return
	 */
	public int countSubstrings(String s) {
        if (s == null || "".equals(s)) return 0;
        char[] arr = s.toCharArray();
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        int result = n;
        for (int i = 0; i < n; i++) isPal[i][i] = true;
        for (int i = 2; i <= n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (j + i - 1 == n) break;
        		if (arr[j] != arr[j + i - 1]) continue;
        		if (i > 2 && !isPal[j + 1][j + i - 2]) continue;
        		isPal[j][j + i - 1] = true;
        		result++;
        	}
        }
        return result;
    }
}
