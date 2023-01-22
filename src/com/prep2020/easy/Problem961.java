package com.prep2020.easy;

public class Problem961 {
	/**
	 * O(N)
	 * @param A
	 * @return
	 */
	public int repeatedNTimes(int[] A) {
        int[] arr = new int[3];
        arr[0] = A[0];
        if (A[1] == arr[0]) return A[1];
        arr[1] = A[1];
        if (A[2] == arr[0] || A[2] == arr[1]) return A[2];
        arr[2] = A[2];
        for (int i = 3; i < A.length; i++) {
        	if (arr[0] == A[i] || arr[1] == A[i] || arr[2] ==A[i]) return A[i];
        	arr[0] = arr[1];
        	arr[1] = arr[2];
        	arr[2] = A[i];
        }
        return -1;
    }
}
