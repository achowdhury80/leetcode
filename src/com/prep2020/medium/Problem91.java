package com.prep2020.medium;

public class Problem91 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		char prev = s.charAt(0);
		if (prev == '0') return 0;
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
        	char c = s.charAt(i);
        	int cur = c > '0' ? dp[1] : 0;
        	if (prev == '1') {
        		cur += dp[0];
        	}
        	else if (prev == '2' && c < '7') {
        		cur += dp[0];
        	}
        	if (cur == 0) return 0;
        	dp[0] = dp[1];
        	dp[1] = cur;
        	prev = c;
        }
        return dp[1];
    }
	
	public static void main(String[] args) {
		Problem91 problem = new Problem91();
		System.out.println(problem.numDecodings("2101"));
	}
}
