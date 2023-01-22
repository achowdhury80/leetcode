package com.prep2020.easy;

public class Problem1422 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int maxScore(String s) {
        int totalZeroCount = 0;
        for (char c : s.toCharArray()) {
        	if (c == '0') totalZeroCount++;
        }
        int zeroCount = 0, result = 0;;
        for (int i = 0; i < s.length() - 1; i++) {
        	if (s.charAt(i) == '0') {
        		zeroCount++;
        	}
        	result = Math.max(result, zeroCount + (s.length() - i - 1 - (totalZeroCount - zeroCount)));
        }
        return result;
    }
}
