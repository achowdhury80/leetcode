package com.prep2020.easy;

public class Problem2027 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int minimumMoves(String s) {
        int result = 0, i = 0;
        while (i < s.length()) {
        	if (s.charAt(i) != 'X') {
        		i++;
        		continue;
        	}
        	result++;
        	i += 3;
        }
        return result;
    }
}
