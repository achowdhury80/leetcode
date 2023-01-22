package com.prep2020.medium.more2000;

public class Problem2270 {
	public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int i : nums) sum += i;
        long min = sum % 2 == 0 ? sum / 2 : (sum + 1) / 2;
        int result = 0;
        sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
        	sum += nums[i];
        	if (sum >= min) result++;
        }
        return result;
    }
}
