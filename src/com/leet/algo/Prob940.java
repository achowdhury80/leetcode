package com.leet.algo;
import java.util.*;
public class Prob940 {
	/**
	 * dp[i] means number of subsequence including ith char
	 * while computing dp[i] subtract all dp[j] where j < i and jth character = ith character
	 * @param S
	 * @return
	 */
	public int distinctSubseqII(String S) {
        char[] arr = S.toCharArray();
        int n = arr.length;
        int[] dp = new int[n];
        int mod = (int)(1e9 + 7);
        int[] counts = new int[26];
        dp[0] = 1;
        int prefixSum = 1;
        counts[arr[0] - 'a'] = 1;
        for (int i = 1; i < n; i++) {
        	int charIdx = arr[i] - 'a';
        	dp[i] = (prefixSum + 1) % mod;
        	dp[i] -= counts[charIdx];
        	if (dp[i] < 0) dp[i] += mod;
        	prefixSum = (prefixSum + dp[i]) % mod;
        	counts[charIdx] = (counts[charIdx] + dp[i]) % mod;
        }
        return prefixSum;
    }
	
	public static void main(String[] args) {
		Prob940 prob = new Prob940();
		System.out.println(prob.distinctSubseqII("abc"));
	}
}
