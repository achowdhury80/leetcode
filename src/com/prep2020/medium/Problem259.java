package com.prep2020.medium;

import java.util.Arrays;

public class Problem259 {
	/**
	 * O(n^2)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
        	result += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return result;
    }
	
	private int twoSumSmaller(int[] nums, int start, int target) {
		int end = nums.length - 1;
		int result = 0;
		while(start < end) {
			if (nums[start] + nums[end] < target) {
				result += end - start;
				start++;
			} else end--;
		}
		return result;
	}
}
