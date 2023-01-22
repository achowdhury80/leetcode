package com.prep2020.easy;

public class Problem53 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
        int result = nums[0], sum = nums[0];
        if (sum < 0) sum = 0;
        for (int i = 1; i < nums.length; i++) {
        	sum += nums[i];
        	result = Math.max(result, sum);
        	if (sum < 0) sum = 0;
        }
        return result;
    }
}
