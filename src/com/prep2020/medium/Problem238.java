package com.prep2020.medium;

public class Problem238 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = 1;
        int left = 1, right = 1;
        for (int i = 0; i < n; i++) {
        	result[i] *= left;
        	result[n - i - 1] *= right;
        	left *= nums[i];
        	right *= nums[n - i - 1];
        }
        return result;
    }
}
