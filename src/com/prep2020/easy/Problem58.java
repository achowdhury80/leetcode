package com.prep2020.easy;

public class Problem58 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord(String s) {
		int result = 0;
        for (int i = s.length() - 1; i > -1; i--) {
        	char c = s.charAt(i);
        	if (c != ' ') {
        		result++;
        	} else if (c == ' ' && result != 0) return result;
        }
        return result;
    }
}
