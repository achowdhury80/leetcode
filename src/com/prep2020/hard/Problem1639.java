package com.prep2020.hard;

public class Problem1639 {
	public int numWays(String[] words, String target) {
        long mod = (long)(1e9 + 7);
        int n = words[0].length();
        int[][] freq = new int[n][26];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < words.length; j++) {
        		freq[i][words[j].charAt(i) - 'a']++;
        	}
        }
        int t = target.length();
        long[][] dp = new long[t][n];
        for (int i = 0; i < t; i++) {
        	for (int j = i; (n - j - 1) >= (t - i - 1); j++) {
        		if (j > 0) dp[i][j] = dp[i][j - 1];
        		int matches = freq[j][target.charAt(i) - 'a'];
        		dp[i][j] = (dp[i][j] + ((i == 0 ? 1 : dp[i - 1][j - 1]) * matches) % mod) % mod;
        	}
        }
        return (int)dp[t - 1][n - 1];
    }
	
	public static void main(String[] args) {
		Problem1639 problem = new Problem1639();
		System.out.println(problem.numWays(new String[] {"acca","bbbb","caca"}, "aba"));
	}
}
