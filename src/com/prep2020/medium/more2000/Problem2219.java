package com.prep2020.medium.more2000;

public class Problem2219 {
	public long maximumSumScore(int[] nums) {
        long sum1 = nums[0], sum2 = nums[0], n = nums.length;
        for (int i = 1; i < n; i++) sum2 += nums[i];
        long result = Math.max(sum1, sum2);
        for (int i = 1; i < n; i++) {
        	sum1 += nums[i];
        	sum2 -= nums[i - 1];
        	result = Math.max(result, Math.max(sum1, sum2));
        }
        return result;
    }
}
