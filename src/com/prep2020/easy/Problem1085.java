package com.prep2020.easy;

public class Problem1085 {
	/**
	 * O(N)
	 * @param A
	 * @return
	 */
	public int sumOfDigits(int[] A) {
        int min = A[0];
        for (int i = 1; i < A.length; i++) min = Math.min(min, A[i]);
        int sum = 0;
        while(min > 0) {
        	sum += min % 10;
        	min /= 10;
        }
        return sum % 2 == 1 ? 0 : 1;
    }
}
