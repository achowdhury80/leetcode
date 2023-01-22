package com.prep2020.easy;

public class Problem1309 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while(i > -1) {
        	char c = s.charAt(i--);
        	if (c == '#') {
        		int val = s.charAt(i--) - '0';
        		val = (s.charAt(i--) -'0') * 10 + val;
        		sb.insert(0, (char)('a' + val - 1));
        	} else sb.insert(0, (char)('a' + (c - '0' - 1)));
        }
        return sb.toString();
    }
}
