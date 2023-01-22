package com.prep2020.easy;

import java.util.Arrays;

public class Problem1099 {
	public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int result = -1;
        while(i < j) {
        	int sum = nums[i] + nums[j];
        	if (sum < k) {
        		result = Math.max(result, sum);
        		i++;
        	} else j--;
        	
        }
        return result;
    }
}
