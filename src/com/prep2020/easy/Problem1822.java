package com.prep2020.easy;

public class Problem1822 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int arraySign(int[] nums) {
        int result = 1;
        for (int num : nums) {
        	if (num == 0) return 0;
        	if (num < 0) result *= (-1);
        }
        return result;
    }
}
