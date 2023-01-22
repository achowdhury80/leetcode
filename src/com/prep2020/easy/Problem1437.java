package com.prep2020.easy;

public class Problem1437 {
	/**
	 * O(N)
	 * sliding window
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean kLengthApart(int[] nums, int k) {
        if (k == 0) return true;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (i > k) sum -= nums[i - k - 1];
        	if (sum > 1) return false;
        }
        return true;
    }
}
