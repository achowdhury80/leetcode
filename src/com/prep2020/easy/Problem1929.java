package com.prep2020.easy;

public class Problem1929 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
        	result[i] = nums[i];
        	result[i + n] = nums[i];
        }
        return result;
    }
}
