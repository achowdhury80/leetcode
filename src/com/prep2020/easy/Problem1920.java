package com.prep2020.easy;

public class Problem1920 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] = nums[i] + n * (nums[nums[i]] % n);
        for (int i = 0; i < n; i++) nums[i] = nums[i] / n;
        return nums;
    }
}
