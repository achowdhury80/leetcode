package com.prep2020.easy;

public class Problem905 {
	/**
	 * O(N)
	 * @param A
	 * @return
	 */
	public int[] sortArrayByParity(int[] A) {
        int evenIdx = -1;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] % 2 == 0) {
        		int temp = A[++evenIdx];
        		A[evenIdx] = A[i];
        		A[i] = temp;
        	}
        }
        return A;
    }
}
