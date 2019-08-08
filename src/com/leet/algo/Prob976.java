package com.leet.algo;

import java.util.Arrays;

public class Prob976 {
	public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i > 1; i--) {
        	if (A[i] < A[i - 1] + A[i - 2]) return A[i] + A[i - 1] + A[i - 2];
        }
        return 0;
    }
}
