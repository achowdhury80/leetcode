package com.leet.algo;


public class Prob903 {
	/**
	 * https://leetcode.com/problems/valid-permutations-for-di-sequence/discuss/196939/Easy-to-understand-solution-with-detailed-explanation
	 * @author aychowdh
	 *
	 */
	public int numPermsDISequence(String S) {
        int mod = (int)(1e9 + 7);
        char[] arr = S.toCharArray();
        int n = S.length();
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
        	for (int j = 0; j <= i; j++) {
        		if (arr[i - 1] == 'D') {
	        		for (int k = j; k < i; k++) {
        				dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
        			}
        		} else {
	        		for (int k = 0; k < j; k++) {
	        			dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
	        		}
        		}
        	}
        }
        int result = 0;
        for (int i = 0; i <= n; i++) {
        	result = (result + dp[n][i]) % mod;
        }
        return result;
    }
}
