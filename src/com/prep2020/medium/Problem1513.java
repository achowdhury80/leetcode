package com.prep2020.medium;

public class Problem1513 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int numSub(String s) {
        int start = -1, mod = (int)(1e9 + 7), result = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '0') start = -1;
        	else {
        		if (start == -1) start = i;
        		result = (result + (i - start + 1)) % mod;
        	}
        }
        return result;
    }
}
