package com.prep2020.medium;

public class Problem5 {
	/**
	 * O(N^2)
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        String result = s.substring(0, 1);
        for (int i = 0; i < n; i++) isPal[i][i] = true;
        for (int i = 2; i <= n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (i + j > n) break;
        		if (s.charAt(j) != s.charAt(j + i - 1)) continue;
        		if (i > 2 && !isPal[j + 1][j + i - 2]) continue;
        		isPal[j][j + i - 1] = true;
        		if (result.length() < i) result = s.substring(j, j + i);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem5 problem = new Problem5();
		System.out.println(problem.longestPalindrome("aacabdkacaa"));
	}
}
