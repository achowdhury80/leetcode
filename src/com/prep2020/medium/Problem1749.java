package com.prep2020.medium;

public class Problem1749 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int maxAbsoluteSum(int[] nums) {
        int max = 0, min = 0, sum = 0, result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	result = Math.max(result, Math.max(Math.abs(sum - max), 
        			Math.abs(sum - min)));
        	max = Math.max(max, sum);
        	min = Math.min(min, sum);
        	
        }
        return result;
    }
}
