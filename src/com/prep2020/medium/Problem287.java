package com.prep2020.medium;

public class Problem287 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int findDuplicate(int[] nums) {
		int n = nums.length;
        for (int num : nums) {
        	num = Math.abs(num);
        	if (num == n - 1) {
        		if (nums[0] < 0) return n - 1;
        		else nums[0] *= (-1);
        	}
        	else {
        		if (nums[num] < 0) return num;
        		else nums[num] *= (-1);
        	}
        }
        return -1;
    }
}
