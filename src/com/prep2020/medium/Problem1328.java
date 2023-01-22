package com.prep2020.medium;

public class Problem1328 {
	/**
	 * O(N)
	 * @param palindrome
	 * @return
	 */
	public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";
        for (int i = 0; i < n / 2; i++) {
        	if (palindrome.charAt(i) > 'a') {
        		return palindrome.substring(0, i) + 'a' 
        				+ palindrome.substring(i + 1);
        	}
        }
        for (int i = n - 1; i >= (n + 1) / 2; i--) {
        	if (palindrome.charAt(i) != 'z') {
        		return palindrome.substring(0, i) 
        				+ (char)(palindrome.charAt(i) + 1) 
        				+ palindrome.substring(i + 1);
        	}
        }
        return "";
    }
}
