package com.prep2020.medium;
public class Problem1910 {
	/**
	 * O(N)
	 * @param s
	 * @param part
	 * @return
	 */
	public String removeOccurrences(String s, String part) {
        if (part.length() > s.length()) return s;
        int i = 0;
        while (i < s.length()) {
        	if (i >= part.length() - 1 && s.substring(i - part.length() + 1, i + 1).equals(part)) {
        		s = s.substring(0, i - part.length() + 1) + s.substring(i + 1);
        		i = i - part.length();
        	}
        	i++;
        }
        return s;
    }
}
