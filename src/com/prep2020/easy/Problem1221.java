package com.prep2020.easy;

public class Problem1221 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int balancedStringSplit(String s) {
        int result = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
        	if (c == 'L') count++;
        	else count--;
        	if (count == 0) result++;
        }
        return result;
    }
}
