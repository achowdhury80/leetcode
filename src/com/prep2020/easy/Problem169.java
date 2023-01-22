package com.prep2020.easy;

public class Problem169 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
        int count = 1, result = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (result == nums[i]) count++;
        	else {
        		if (count == 0) {
        			result = nums[i];
        			count++;
        		} else count--;
        	}
        }
        return result;
    }
}
