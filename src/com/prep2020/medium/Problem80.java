package com.prep2020.medium;

public class Problem80 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length < 3) return nums.length;
        int idx = 1;
        for (int i = 2; i < nums.length; i++) {
        	if (nums[i] != nums[idx] || nums[i] != nums[idx - 1]) {
        		nums[++idx] = nums[i];
        	}
        }
        return idx + 1;
    }
}
