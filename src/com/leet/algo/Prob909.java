package com.leet.algo;

public class Prob909 {
	public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int i = 1; i < A.length; i++) {
        	min = Math.min(min, A[i]);
        	max = Math.max(max, A[i]);
        }
        int temp = max - min - 2 * K;
        return temp > 0 ? temp : 0;
    }
}
