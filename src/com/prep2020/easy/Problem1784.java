package com.prep2020.easy;

public class Problem1784 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public boolean checkOnesSegment(String s) {
		boolean zeroFound = false;
        for (int i = 1; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '1' && zeroFound) return false;
        	else if (c == '0') zeroFound = true;
        }
        return true;
    }
}
