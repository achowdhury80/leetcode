package com.prep2020.easy;

public class Problem2016 {
	/**
	 * O(n)
	 * @param nums
	 * @return
	 */
	public int maximumDifference(int[] nums) {
        int result = Integer.MIN_VALUE, min = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] > min) result = Math.max(result, nums[i] - min);
        	min = Math.min(min, nums[i]);
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
