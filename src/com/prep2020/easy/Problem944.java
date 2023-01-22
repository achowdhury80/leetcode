package com.prep2020.easy;

public class Problem944 {
	/**
	 * O(N * W) N = no of words, w = length of each word
	 * @param A
	 * @return
	 */
	public int minDeletionSize(String[] A) {
		if (A.length < 2) return 0;
        int result = 0;
        for (int i = 0; i < A[0].length(); i++) {
        	char last = A[0].charAt(i);
        	for (int j = 1; j < A.length; j++) {
        		char c = A[j].charAt(i);
        		if (last > c) {
        			result++;
        			break;
        		} else last = c;
        	}
        }
        return result;
    }
}
