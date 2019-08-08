package com.leet.algo;

public class Prob961 {
	public int repeatedNTimes(int[] A) {
        int arr[] = new int[] {-1, -1, -1};
        for (int i = 0; i < A.length; i++) {
        	if (A[i] == arr[2] || A[i] == arr[1] || A[i] == arr[0]) return A[i];
        	arr[0] = arr[1];
        	arr[1] = arr[2];
        	arr[2] = A[i];
        }
        return -1;
    }
}
