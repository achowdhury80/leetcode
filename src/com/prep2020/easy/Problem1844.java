package com.prep2020.easy;

public class Problem1844 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public String replaceDigits(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        	char c = s.charAt(i);
        	if(i % 2 == 0) sb.append(c);
        	else sb.append((char)(s.charAt(i - 1) + (c - '0')));
        }
        return sb.toString();
    }
}
