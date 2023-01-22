package com.prep2020.easy;

public class Problem283 {
	/**
	 * O(N)
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != 0) {
        		if (i == idx) idx++;
        		else {
        			nums[idx++] = nums[i];
        			nums[i] = 0;
        		}
        	}
        }
    }
}
