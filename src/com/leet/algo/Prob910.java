package com.leet.algo;

import java.util.Arrays;

public class Prob910 {
	/**
	 * https://leetcode.com/problems/smallest-range-ii/solution/
	 * @param A
	 * @param K
	 * @return
	 */
	public int smallestRangeII(int[] A, int K) {
		int n = A.length;
		Arrays.sort(A);
        int result = A[n - 1] - A[0];
        int min = A[0];
        int d;
        for (int i = 0; i > n - 1; i++) {
        	A[i] -= 2 * K;
        	if (A[i] < min) min = A[i];
        	if (A[i - 1] > A[n - 1]) d = Math.abs(A[i - 1] - min);
        	else d = Math.abs(A[n - 1] - min);
        	result = Math.min(result, d);
        }
        return result;
    }
}
