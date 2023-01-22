package com.prep2020.medium;

public class Problem581 {
	public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int begin = -1, end = -2, max = nums[0], min = nums[n - 1];
        for (int i = 1; i < nums.length; i++) {
        	max = Math.max(max, nums[i]);
        	min = Math.min(min, nums[n - i - 1]);
        	if (nums[i] < max) end = i;
        	if (nums[n - i - 1] > min) begin = n - i - 1;
        }
        return end - begin + 1;
    }
}
