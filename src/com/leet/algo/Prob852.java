package com.leet.algo;

public class Prob852 {
	public int peakIndexInMountainArray(int[] A) {
        return helper(A, 0, A.length - 1);
    }
	
	private int helper(int[] A, int start, int end) {
        while (start < end) {
        	int mid = start + (end -start) / 2;
        	if(A[mid] > A[mid + 1] ) {
        		if (A[mid] > A[mid - 1]) return mid;
        		end = mid;
        	} else start = mid;
        	
        }
        return A[start];
    }
}
