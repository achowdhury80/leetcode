package com.prep2020.medium;

public class Problem516 {
	/**
	 * O(N^2) time and space
	 * @param s
	 * @return
	 */
	public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) arr[i][i] = 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (j + i > n) break;
        		if (s.charAt(j) == s.charAt(j + i - 1)) 
        			arr[j][j + i - 1] = 2 + (i > 2 ? (arr[j + 1][j + i - 2]): 0);
        		else arr[j][j + i - 1] = Math.max(arr[j][j + i - 2], arr[j + 1][j + i - 1]);
        		result = Math.max(result, arr[j][j + i - 1]);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem516 problem = new Problem516();
		System.out.println(problem.longestPalindromeSubseq("bbbab"));
	}
}
