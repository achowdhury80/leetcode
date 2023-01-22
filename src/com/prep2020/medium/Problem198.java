package com.prep2020.medium;

public class Problem198 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		if (nums.length < 2) return nums[0];
        int[] lastTwo = new int[2];
        lastTwo[0] = nums[0];
        lastTwo[1] = Math.max(lastTwo[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
        	int cur = Math.max(lastTwo[1], nums[i] + lastTwo[0]);
        	lastTwo[0] = lastTwo[1];
        	lastTwo[1] = cur;
        }
        return lastTwo[1];
    }
}
