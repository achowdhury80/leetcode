package com.prep2020.easy;

public class Problem709 {
	/**
	 * O(N)
	 * @param str
	 * @return
	 */
	public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
        	if (c >= 'A' && c <= 'Z') {
        		c = (char)('a' + (c - 'A'));
        	}
        	sb.append(c);
        }
        return sb.toString();
    }
}
