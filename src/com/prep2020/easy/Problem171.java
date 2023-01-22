package com.prep2020.easy;

public class Problem171 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int titleToNumber(String s) {
        int result = 0;
        int mult = 1;
        for (int i = s.length() - 1; i > -1; i--) {
        	char c = s.charAt(i);
        	result += (c - 'A' + 1) * mult;
        	mult *= 26;
        }
        return result;
    }
}
