package com.prep2020.easy;

public class Problem1470 {
	/**
	 * https://leetcode.com/problems/shuffle-the-array/discuss/675956/In-Place-O(n)-Time-O(1)-Space-With-Explanation-and-Analysis
	 * O(N) and O(1)
	 * @param nums
	 * @param n
	 * @return
	 */
	public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
        	nums[i] = (nums[i] | (nums[n + i] << 10));
        }
        for (int i = n - 1; i > -1; i--) {
            nums[2 * i + 1] = (nums[i] >> 10);
        	nums[2 * i] = (nums[i] & ((1 << 10) - 1));
        }
        return nums;
    }
}
