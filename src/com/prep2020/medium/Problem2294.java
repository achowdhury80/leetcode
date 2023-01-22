package com.prep2020.medium;

import java.util.Arrays;

public class Problem2294 {
	public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0, start = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] - start > k) {
        		result++;
        		start = nums[i];
        	}
        }
        result++;
        return result;
    }
}
