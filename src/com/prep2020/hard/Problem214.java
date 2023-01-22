package com.prep2020.hard;

public class Problem214 {
	/**
	 * O(N^2) time - iterating through the string; at each step substring match which
	 * is linear
	 * O(N) space
	 * @param s
	 * @return
	 */
	public String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        for (int i = 0; i <= s.length(); i++) {
        	if (s.startsWith(reverse.substring(i))) {
        		return reverse.substring(0, i) + s;
        	}
        }
        return reverse + s;
    }
}
