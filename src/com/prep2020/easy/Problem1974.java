package com.prep2020.easy;

public class Problem1974 {
	/**
	 * O(N)
	 * @param word
	 * @return
	 */
	public int minTimeToType(String word) {
		char cur = 'a';
		int result = 0;
        for (char c : word.toCharArray()) {
        	if (c != cur) {
        		int diff = Math.abs(c - cur);
        		diff = Math.min(diff, 26 - diff);
        		result += diff;
        	}
        	result++;
        	cur = c;
        }
        return result;
    }
}
