package com.prep2020.medium;

public class Problem1827 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int minOperations(int[] nums) {
        int result = 0, last = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] <= last) {
        		last = last + 1;
        		result += (last - nums[i]);
        	} else last = nums[i];
        }
        return result;
    }
}
