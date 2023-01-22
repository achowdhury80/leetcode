package com.prep2020.easy;

public class Problem125 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while(i < j) {
			char left = s.charAt(i);
			if (!isAlpha(left)) {
				i++;
				continue;
			}
			char right = s.charAt(j);
			if (!isAlpha(right)) {
				j--;
				continue;
			}
			if (Character.toLowerCase(left) != Character.toLowerCase(right)) return false;
			i++;
			j--;
		}
		return true;
    }
	
	private boolean isAlpha(char c) {
		return (c >= 'A' && c <= 'Z')
				|| (c >= 'a' && c <= 'z')
				|| (c >= '0' && c <='9');
	}
}
