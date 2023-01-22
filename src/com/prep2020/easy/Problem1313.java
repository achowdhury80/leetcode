package com.prep2020.easy;

public class Problem1313 {
	/**
	 * O(total frequency)
	 * @param nums
	 * @return
	 */
	public int[] decompressRLElist(int[] nums) {
		int length = 0;
		// find total frequency
        for (int i = 0; i < nums.length; i += 2) {
        	length += nums[i];
        }
        int[] result = new int[length];
        int idx = 0;
        // fill up the result array
        for (int i = 0; i < nums.length; i += 2) {
        	for (int j = 0; j < nums[i]; j++) result[idx++] = nums[i + 1];
        }
        return result;
    }
}
