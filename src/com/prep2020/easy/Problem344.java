package com.prep2020.easy;

public class Problem344 {
	/**
	 * O(N)
	 * @param s
	 */
	public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        char c;
        while(i < j) {
        	c = s[i];
        	s[i++] = s[j];
        	s[j--] = c;
        }
    }
}
