package com.prep2020.easy;

public class Problem1446 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int maxPower(String s) {
        int result = 1, count = 1;
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == last) {
        		count++;
        		result = Math.max(result, count);
        	} else {
        		count = 1;
        		last = c;
        	}
        }
        return result;
    }
}
