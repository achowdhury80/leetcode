package com.prep2020.easy;

public class Problem2108 {
	public String firstPalindrome(String[] words) {
        for (String w : words) {
        	if (isPalindromic(w)) return w;
        }
        return "";
    }

	private boolean isPalindromic(String w) {
		int n = w.length();
		int i = 0, j = n - 1;
		while(i < j) {
			if (w.charAt(i) != w.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
}
