package com.prep2020.medium.more2000;

public class Problem2266 {
	public int countTexts(String pressedKeys) {
		int n = pressedKeys.length();
        long[] dp = new long[n];
        long mod = (long)(1e9 + 7);
        dp[0] = 1l;
        for (int i = 1; i < n; i++) {
        	long count = dp[i - 1];
        	char c = pressedKeys.charAt(i);
        	if (pressedKeys.charAt(i - 1) == c) {
        		count += (i > 1 ? dp[i - 2] : 1);
        		count %= mod;
        		if (i > 1 && pressedKeys.charAt(i - 2) == c) {
        			count += (i > 2 ? dp[i - 3] : 1);
            		count %= mod;
            		if (i > 2 && (c == '7' || c == '9') && pressedKeys.charAt(i - 3) == c) {
            			count += (i > 3 ? dp[i - 4] : 1);
                		count %= mod;
            		}
        		}
        	}
        	dp[i] = count;
        }
        return (int)dp[n - 1];
    }
}
