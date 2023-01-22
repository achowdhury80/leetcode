package com.prep2020.medium;

public class Problem413 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int numberOfArithmeticSlices(int[] nums) {
        int prevGap = -1, prevCount = 0;
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
        	int gap = nums[i] - nums[i - 1];
        	if (prevCount > 0 && gap == prevGap) {
        		prevCount++;
        		result += prevCount - 2;
        	} else {
        		prevGap = gap;
        		prevCount = 2;
        	}
        }
        return result;
    }
}
