package com.leet.algo;

public class Prob664 {
	/**
	 * https://leetcode.com/problems/strange-printer/solution/
	 * @param s
	 * @return
	 */
	public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        char[] arr = s.toCharArray();
        return count(arr, 0, n - 1, dp);
    }
	
	private int count(char[] arr, int i, int j, int[][] dp) {
		if (i > j) return 0;
		if (dp[i][j] != 0) return dp[i][j];
		dp[i][j] = 1 + count(arr, i + 1, j, dp);
		for (int k = i + 1; k <= j; k++) {
			if(arr[i] == arr[k])
				dp[i][j] = Math.min(dp[i][j], count(arr, i, k - 1, dp) 
						+ count(arr, k + 1, j, dp));
		}
		return dp[i][j];
	}
}
