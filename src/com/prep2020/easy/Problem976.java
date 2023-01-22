package com.prep2020.easy;

import java.util.Arrays;

public class Problem976 {
	/**
	 * O(LOGN)
	 * @param A
	 * @return
	 */
	public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i > 1; i--) {
        	if (A[i] < A[i - 1] + A[i - 2]) return A[i] + A[i - 1] + A[i - 2];
        }
        return 0;
    }
}
