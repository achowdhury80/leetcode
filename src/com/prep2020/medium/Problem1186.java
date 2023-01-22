package com.prep2020.medium;

public class Problem1186 {
	/**
	 * Consider the max sum of all subarrays ending at i (inclusive). t0 is the sum 
	 * with 0 deletion, t1 is with 1 deletion
	**/
	public int maximumSum(int[] arr) {
        int t0 = arr[0], t1 = 0, result = arr[0];
        for (int i = 1; i < arr.length; i++) {
        	int temp = t0;
        	t0 = arr[i] + Math.max(t0, 0);
        	t1 = Math.max(temp, arr[i] + t1);
        	result = Math.max(result, Math.max(t0, t1));
        }
        return result;
    }
}
