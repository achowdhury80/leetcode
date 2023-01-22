package com.prep2020.medium;

public class Problem487 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
        int start = -1;
        int result = 0, lastZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 1 || lastZeroIndex == -1) {
        		result = Math.max(result, i - start);
        		if (nums[i] == 0) lastZeroIndex = i;
        	} else {
        		start = lastZeroIndex;
        		lastZeroIndex = i;
        	}
        }
        return result;
    }
}
