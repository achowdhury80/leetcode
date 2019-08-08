package com.leet.algo;

public class Prob905 {
	public int[] sortArrayByParity(int[] A) {
        int start = 0, end = A.length - 1;
        while(start < end) {
        	if (A[start] % 2 == 0) {
        		++start;
        		continue;
        	}
        	if (A[end] % 2 == 1) {
        		--end;
        		continue;
        	}
        	swap(A, start, end);
        }
        return A;
    }
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
