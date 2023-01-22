package com.prep2020.easy;

public class Problem1704 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public boolean halvesAreAlike(String s) {
		int count = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if ("aeiou".indexOf(Character.toLowerCase(c)) > -1) {
        		if (i >= s.length() / 2) count--;
        		else count++;
        	}
        }
        return count == 0;
    }
}
