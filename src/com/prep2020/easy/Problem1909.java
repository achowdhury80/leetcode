package com.prep2020.easy;

public class Problem1909 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public boolean canBeIncreasing(int[] nums) {
		boolean used = false;
		int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] <= last) {
        		if(used) return false;
        		used = true;
        		if (nums[i] == last) continue;
        		if (i - 2 < 0 || nums[i - 2] < nums[i]) last = nums[i];
        	} else last = nums[i];
        }
        return true;
    }
}
