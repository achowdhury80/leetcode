package com.prep2020.easy;

public class Problem1869 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public boolean checkZeroOnes(String s) {
        int[] maxZeroOneCount = new int[] {0, 0};
        char last = s.charAt(0);
        int curCount = 1;
        for (int i = 1; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == last) curCount++;
        	else {
        		int idx = last - '0';
        		maxZeroOneCount[idx] = Math.max(maxZeroOneCount[idx], curCount);
        		curCount = 1;
        		last = c;
        	}
        }
        int idx = last - '0';
		maxZeroOneCount[idx] = Math.max(maxZeroOneCount[idx], curCount);
		return maxZeroOneCount[1] > maxZeroOneCount[0];
    }
}
