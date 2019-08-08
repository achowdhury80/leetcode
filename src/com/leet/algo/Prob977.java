package com.leet.algo;

public class Prob977 {
	public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int start = 0, end = A.length - 1;
        int idx = end;
        while(start <= end) {
        	if (Math.abs(A[start]) > Math.abs(A[end])) {
        		result[idx--] = A[start] * A[start];
        		start++;
        	} else {
        		result[idx--] = A[end] * A[end];
        		end--;
        	}
        }
        return result;
    }
}
