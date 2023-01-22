package com.prep2020.medium;

public class Problem1567 {
	/**
	 * O(n)
	 * @param nums
	 * @return
	 */
	public int getMaxLen(int[] nums) {
        int result = 0, firstNegativeIdx = -1, negativeCount = 0, start = -1;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 0) {
        		firstNegativeIdx = -1;
        		start = i;
        		negativeCount = 0;
        		continue;
        	}
        	if (nums[i] < 0) {
        		negativeCount++;
        		if (negativeCount % 2 == 0) result = Math.max(result, i - start);
        		else {
        			if (firstNegativeIdx == -1) firstNegativeIdx = i;
        			else result = Math.max(result, i - firstNegativeIdx);
        		}
        	} else {
        		if (negativeCount % 2 == 0) result = Math.max(result, i - start);
        		else result = Math.max(result, i - firstNegativeIdx);
        	}
        }
        return result;
    }
}
