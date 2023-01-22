package com.prep2020.medium;

import java.util.Arrays;

public class Problem910 {
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
        for (int i = 0; i < n - 1; i++) {
        	int high = Math.max(A[n - 1] - K, A[i] + K);
        	int low = Math.min(A[0] + K, A[i + 1] - K);
        	result = Math.min(result, high - low);
        }
        return result;
    }
}
