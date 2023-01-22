package com.prep2020.easy;

public class Problem1800 {
	public int maxAscendingSum(int[] nums) {
        int result = nums[0], curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] <= nums[i - 1]) curSum = nums[i];
        	else curSum += nums[i];
        	result = Math.max(result, curSum);
        }
        return result;
    }
}
