package com.prep2020.easy;

import java.util.Arrays;

public class Problem1608 {
	/**
	 * O(NlogN)
	 * @param nums
	 * @return
	 */
	public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
        	if (i > 0 && nums[i] == nums[i - 1]) continue;
        	int count = nums.length - i;
        	if (nums[i] == count || (nums[i] > count && (i == 0 || nums[i - 1] < count))) 
        		return count;
        }
        return -1;
    }
}
