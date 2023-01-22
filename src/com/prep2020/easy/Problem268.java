package com.prep2020.easy;

public class Problem268 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
		int xor = 0;
        for (int i = 0; i < nums.length; i++) {
        	xor ^= (i ^ nums[i]);
        }
        xor ^= nums.length;
        return xor;
    }
}
