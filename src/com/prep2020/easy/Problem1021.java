package com.prep2020.easy;

public class Problem1021 {
	/**
	 * O(N)
	 * @param S
	 * @return
	 */
	public String removeOuterParentheses(String S) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
        for (char c : S.toCharArray()) {
        	if (c == '(') {
        		count++;
        		if (count > 1) sb.append(c); 
        	} else {
        		count--;
        		if (count > 0) sb.append(c);
        	}
        }
        return sb.toString();
    }
}
