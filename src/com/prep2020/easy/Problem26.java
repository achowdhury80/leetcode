package com.prep2020.easy;

public class Problem26 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length < 1) return 0;
		int result = 1;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] != nums[result - 1]) {
        		nums[result] = nums[i];
        		result++;
        	}
        }
        return result;
    }
}
