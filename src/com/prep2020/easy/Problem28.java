package com.prep2020.easy;

public class Problem28 {
	/**
	 * O(N * M) where N = haystack length and M = needle.length
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
        	for (int j = 0; ; j++) {
        		if (j == needle.length()) return i;
        		if (i + j == haystack.length()) return -1;
        		if (haystack.charAt(i + j) != needle.charAt(j)) break;
        	}
        }
    }	
}
