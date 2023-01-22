package com.prep2020.easy;

public class Problem1752 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public boolean check(int[] nums) {
        if (nums.length < 3) return true;
        boolean rotated = false;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] < nums[i - 1]) {
        		if (rotated) return false;
        		rotated = true;
        	}
        }
        if (rotated) return nums[nums.length - 1] <= nums[0];
        return true;
    }
}
