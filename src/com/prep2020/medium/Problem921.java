package com.prep2020.medium;

public class Problem921 {
	/**
	 * O(N)
	 * @param S
	 * @return
	 */
	public int minAddToMakeValid(String S) {
        int count = 0, result = 0;
        for (char c : S.toCharArray()) {
        	if (c == '(') count++;
        	else {
        		if (count == 0) result++;
        		else count--;
        	}
        }
        return result + count;
    }
}
