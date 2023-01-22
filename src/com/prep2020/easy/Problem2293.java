package com.prep2020.easy;

public class Problem2293 {
	public int minMaxGame(int[] nums) {
		int n = nums.length;
        if (n == 1) return nums[0];
        int[] arr = new int[n / 2];
        for (int i = 0; i < arr.length; i++) {
        	if (i % 2 == 0) arr[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
        	else arr[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
        }
        return minMaxGame(arr);
    }
}
