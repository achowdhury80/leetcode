package com.prep2020.medium;

public class Problem639 {
	/**
	 * O(N) time and O(1) space
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		if (s.charAt(0) == '0') return 0;
        long[] dp = new long[] {1, 1};
        if (s.charAt(0) == '*') dp[1] = 9;
        long mod = (long)(1e9 + 7);
        for (int i = 1; i < s.length(); i++) {
        	char c = s.charAt(i);
        	// considering one char
        	long temp = 0;
        	// lets consider all the cases with this and prev char
        	char prev = s.charAt(i - 1);
        	if (prev == '1') {
        		if (c == '*') {
        			temp = (temp + 9) % mod;
        		} else temp = (temp + 1) % mod;
        	} else if (prev == '2') {
        		if (c == '*') {
        			temp = (temp + 6) % mod;
        		} else if (c >= '0' && c <= '6') temp = (temp + 1) % mod;
        	} else if (prev == '*') {
        		if (c == '*') {
        			temp = (temp + 15) % mod;
        		} else if (c >= '0' && c <= '6') temp = (temp + 2) % mod;
        		else temp = (temp + 1) % mod;
        	}
        	temp = (dp[0] * temp) % mod;
        	temp += (dp[1] * (c == '0' ? 0 : (c == '*' ? 9 : 1))) % mod;
        	dp[0] = dp[1];
        	dp[1] = temp;
        }
        return (int)dp[1];
    }
	
	public static void main(String[] args) {
		Problem639 problem = new Problem639();
//		System.out.println(problem.numDecodings("*1"));
//		System.out.println(problem.numDecodings("**"));
//		System.out.println(problem.numDecodings("***"));
		System.out.println(problem.numDecodings("1*72*"));
	}
}
