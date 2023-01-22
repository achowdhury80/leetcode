package com.prep2020.easy;

public class Problem1413 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int minStartValue(int[] nums) {
        int result = 1, sum = 0;
        for (int i : nums) {
        	sum += i;
        	result = Math.max(result, 1 - sum);
        }
        return result;
    }
}
