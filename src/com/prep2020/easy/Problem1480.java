package com.prep2020.easy;

public class Problem1480 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];
        return nums;
    }
}
