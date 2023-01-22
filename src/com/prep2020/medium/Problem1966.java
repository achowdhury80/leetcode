package com.prep2020.medium;

public class Problem1966 {
	public int binarySearchableNumbers(int[] nums) {
        int n = nums.length;
        int[] maxArr = new int[n], minArr = new int[n];
        maxArr[0] = nums[0];
        minArr[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
        	maxArr[i] = Math.max(maxArr[i - 1], nums[i]);
        	minArr[n - i - 1] = Math.min(minArr[n - i], nums[n - i - 1]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
        	if (maxArr[i] == minArr[i] && nums[i] == maxArr[i]) result++;
        }
        return result;
    }
}
