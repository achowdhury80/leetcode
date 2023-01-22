package com.prep2020.easy;

public class Problem27 {
	/**
	 * O(N)
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		if (nums.length < 1) return 0;
		int result = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != val) {
        		nums[result] = nums[i];
        		result++;
        	}
        }
        return result;
    }
}
