package com.prep2020.medium;

public class Problem915 {
	/**
	 * o(n)
	 * @param nums
	 * @return
	 */
	public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0], max = nums[0], leftEnd = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] < leftMax) {
        		leftMax = max;
        		leftEnd = i;
        	} else {
        		max = Math.max(max, nums[i]);
        	}
        }
        return leftEnd + 1;
    }
}
