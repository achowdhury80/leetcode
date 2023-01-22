package com.prep2020.medium.more2000;

public class Problem2221 {
	public int triangularSum(int[] nums) {
        int n = nums.length;
        while (n > 1) {
        	n--;
        	for (int i = 0; i < n; i++) {
        		nums[i] = (nums[i] + nums[i + 1]) % 10;
        	}
        }
        return nums[0];
    }
}
