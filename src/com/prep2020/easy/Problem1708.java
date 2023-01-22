package com.prep2020.easy;

public class Problem1708 {
	/**
	 * O(N)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] largestSubarray(int[] nums, int k) {
        int startIndex = 0;
        for (int i = 1; i <= nums.length - k; i++) {
        	if (nums[startIndex] < nums[i]) startIndex = i;
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
        	result[i] = nums[startIndex + i];
        }
        return result;
    }
}
