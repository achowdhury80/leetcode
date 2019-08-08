package com.leet.algo;

public class Prob922 {
	public int[] sortArrayByParityII(int[] A) {
        int even = 0, odd = 1;
        while(even < A.length && odd < A.length) {
        	if (A[even] % 2 == 0) {
        		even += 2;
        		continue;
        	}
        	if (A[odd] % 2 == 1) {
        		odd += 2;
        		continue;
        	}
        	swap(A, even, odd);
        	even += 2;
        	odd += 2;
        }
        return A;
    }
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
