package com.prep2020.easy;

public class Problem136 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) result ^= i;
        return result;
    }
}
