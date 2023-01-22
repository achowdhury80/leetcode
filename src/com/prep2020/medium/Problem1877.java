package com.prep2020.medium;

import java.util.Arrays;

public class Problem1877 {
	/**
	 * O(NlogN)
	 * @param nums
	 * @return
	 */
	public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
        	result = Math.max(result, nums[i] + nums[j]);
        }
        return result;
    }
}
