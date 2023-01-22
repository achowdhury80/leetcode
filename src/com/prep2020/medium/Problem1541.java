package com.prep2020.medium;

public class Problem1541 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int minInsertions(String s) {
        int result = 0;
        int openLeft = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '(') openLeft++;
        	else {
        		if (i == s.length() - 1 || s.charAt(i + 1) != ')') {
        			result++;
        		} else i++;
        		if (openLeft == 0) result++;
        		else openLeft--;
        	}
        }
        return result + 2 * openLeft;
    }
}
