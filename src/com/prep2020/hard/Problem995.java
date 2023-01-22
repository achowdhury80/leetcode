package com.prep2020.hard;

public class Problem995 {
	/**
	 * O(N)
	 * https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/1383003/c%2B%2B-or-O(n)-time-or-using-line-sweep
	 * @param nums
	 * @param k
	 * @return
	 */
	public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flip = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
        	if (i > 0) flip[i] += flip[i - 1];
        	if (flip[i] % 2 == 0 && nums[i] == 0 || flip[i] % 2 == 1 && nums[i] == 1) {
        		result++;
        		flip[i]++;
        		if (i + k > n) return -1;
        		if (i + k < n) flip[i + k]--;
        	}
        }
        return result;
    }
}
