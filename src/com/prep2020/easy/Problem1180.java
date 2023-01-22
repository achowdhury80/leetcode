package com.prep2020.easy;

public class Problem1180 {
	/**
	 * O(N)
	 * @param S
	 * @return
	 */
	public int countLetters(String S) {
		int count = 1;
		char last = S.charAt(0);
		int result = 1;
        for (int i = 1; i < S.length(); i++) {
        	char c = S.charAt(i);
        	if (c == last) count++;
        	else {
        		last = c;
        		count = 1;
        	}
        	result += count;
        }
        return result;
    }
}
