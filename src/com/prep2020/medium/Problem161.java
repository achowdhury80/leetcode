package com.prep2020.medium;

public class Problem161 {
	/**
	 * O(N)
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.length() > t.length()) return isOneEditDistance(t, s);
        boolean used = false;
        if (s.length() < t.length()) { // insert
        	int i = 0, j = 0;
        	while(i < s.length() && j < t.length()) {
        		if (s.charAt(i) != t.charAt(j)) {
        			if (used) return false;
        			used = true;
        			j++;
        		} else {
        			i++;
        			j++;
        		}
        	}
        	return used && j == t.length() || !used && j < t.length();
        } else { // replace
        	for (int i = 0; i < s.length(); i++) {
        		if (s.charAt(i) != t.charAt(i)) {
        			if (used) return false;
        			used = true;
        		}
        	}
        	return used;
        }
    }
}
