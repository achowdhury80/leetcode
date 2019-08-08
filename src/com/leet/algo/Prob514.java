package com.leet.algo;

public class Prob514 {
	/**
	 * Idea
Basic idea is we pick a char from key and for each occurance of it in ring, we align that char at 12:00 and check the cost for the next char from key. Along the way, we add up all the costs for all chars in key and pick the min.
dp[i][j] indicates minimum cost for substring key[0..j] in the ring state i (that is ith char is aligned at 12:00, there are only ring.length states possible.).
	 * @param ring
	 * @param key
	 * @return
	 */
	public int findRotateSteps(String ring, String key) {
		int m = ring.length(), n = key.length();
        Integer[][] dp = new Integer[m][n];
        return findSteps(0, ring, 0, key, dp);
    }
	
	/*
	 * i = ring state starting from 0, j = index of char in key
	 */
	private int findSteps(int i, String ring, int j, String key, Integer[][] dp) {
		if (j == key.length()) return 0;
		if (dp[i][j] != null) return dp[i][j];
		dp[i][j] = Integer.MAX_VALUE;
		char ch = key.charAt(j);
		for (int k = 0; k < ring.length(); k++) {
			int temp = (k + i) % ring.length();
			if (ch == ring.charAt(temp)) {
				dp[i][j] = Math.min(dp[i][j], 1 + Math.min(k, ring.length() - k) + findSteps(temp, ring, j + 1, key, dp));
			}
		}
		return dp[i][j];
	}
	
	
}
