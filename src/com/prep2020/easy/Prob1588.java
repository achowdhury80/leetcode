package com.prep2020.easy;

public class Prob1588 {
	/**
	 * O(N)
	 * at any index i, try to find even and odd subarray sum with including that element
	 * keep track of even and odd subarray count
	 * @param arr
	 * @return
	 */
	public int sumOddLengthSubarrays(int[] arr) {
        int evenSum = 0, evenCount = 0, oddSum = 0, oddCount = 0, result = 0;
        for (int i = 0; i < arr.length; i++) {
        	int temp = arr[i] + (evenSum + evenCount * arr[i]);
        	evenSum = oddSum + oddCount * arr[i];
        	evenCount = (i + 1) / 2;
        	oddSum = temp;
        	oddCount = (i + 2) / 2;
        	result += oddSum;
        }
        return result;
    }
}
