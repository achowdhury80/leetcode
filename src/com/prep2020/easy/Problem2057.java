package com.prep2020.easy;

public class Problem2057 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == i % 10) return i;
        }
        return -1;
    }
}
