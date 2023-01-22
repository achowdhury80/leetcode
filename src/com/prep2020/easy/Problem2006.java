package com.prep2020.easy;

public class Problem2006 {
	/**
	 * O(N)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int countKDifference(int[] nums, int k) {
        int[] arr = new int[101];
        for (int num : nums) arr[num]++;
        int result = 0;
        for (int i = k; i < 101; i++) {
        	result += arr[i] * arr[i - k];
        }
        return result;
    }
}
