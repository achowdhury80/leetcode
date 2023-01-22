package com.prep2020.easy;

public class Problem645 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
        	int num = Math.abs(nums[i]);
        	if (num == nums.length) num = 0;
        	if (nums[num] < 0) {
        		result[0] = (num == 0 ? nums.length : num);
        	} else nums[num] *= -1;
        }
        if (nums[0] > 0) {
        	result[1] = nums.length;
        	return result;
        }
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] > 0) {
        		result[1] = i;
        		return result;
        	}
        }
        return result;
    }
}
