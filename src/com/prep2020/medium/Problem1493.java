package com.prep2020.medium;

public class Problem1493 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int longestSubarray(int[] nums) {
        int lastZeroIndex = -1, start = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 0) {
        		result = Math.max(result, i - lastZeroIndex - 1);
        		start = lastZeroIndex + 1;
        		lastZeroIndex = i;
        	} else result = Math.max(result, i - start);
        }
        return result;
    }
}
