package com.leet.algo;

public class Prob944 {
	public int minDeletionSize(String[] A) {
        int result = 0;
        for (int i = 0; i < A[0].length(); i++) {
        	for (int j = 1; j < A.length; j++) {
        		if (A[j].charAt(i) < A[j - 1].charAt(i)) {
        			result++;
        			break;
        		}
        	}
        }
        return result;
    }
}
