package com.prep2020.easy;

public class Problem1863 {
	/**
	 * O(n * 2 ^ n)
	 * @param nums
	 * @return
	 */
	public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < Math.pow(2, n); i++) {
        	int cur = 0;
        	for (int j = 0; j < n; j++) {
        		if (((i >> j) & 1) > 0) cur ^= nums[j];
        	}
        	result += cur;
        }
        return result;
    }
}
