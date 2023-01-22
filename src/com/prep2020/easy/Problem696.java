package com.prep2020.easy;

public class Problem696 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int countBinarySubstrings(String s) {
		int i = 1;
		int lastCount = 1;
		while(i < s.length()) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				lastCount++;
				i++;
			} else break;
		}
		int result = 0;
		int curCount = lastCount;
        while(i < s.length()) {
        	if (s.charAt(i) != s.charAt(i - 1)) {
        		lastCount = curCount;
        		curCount = 1;
        		result++;
        	} else {
        		curCount++;
        		if (curCount <= lastCount) result++;
        	}
        	i++;
        }
        return result;
    }
}
