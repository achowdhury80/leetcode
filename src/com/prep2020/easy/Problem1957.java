package com.prep2020.easy;

public class Problem1957 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (i < 2) sb.append(c);
        	else {
        		if (c != sb.charAt(sb.length() - 1) 
        				|| c != sb.charAt(sb.length() - 2)) sb.append(c);
        	}
        }
        return sb.toString();
    }
}
