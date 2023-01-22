package com.prep2020.medium;

public class Problem880 {
	/**
	 * https://leetcode.com/problems/decoded-string-at-index/solution/
	 * @param S
	 * @param K
	 * @return
	 */
	public String decodeAtIndex(String S, int K) {
		long size = 0;
        int n = S.length();
        for (char c : S.toCharArray()) {
        	if (Character.isLetter(c)) size++;
        	else size *= (c - '0');
        }
        for (int i = n - 1; i > -1; i--) {
        	char c = S.charAt(i);
        	K %= size;
        	if (Character.isLetter(c)) {
        		if (K == 0) return "" + c;
        		size--;
        	} else size /= (c - '0');
        }
        return "";
    }
}
