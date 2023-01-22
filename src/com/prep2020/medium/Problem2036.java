package com.prep2020.medium;

public class Problem2036 {
	public long maximumAlternatingSubarraySum(int[] nums) {
		if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, true), helper(nums, false));
    }
	
	private long helper(int[] nums, boolean evenPositive) {
		long sum = 0, min = 0, result = Long.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 && !evenPositive) continue;
			sum += ((i % 2 == 0) == evenPositive) ? nums[i] : (-nums[i]);
			result = Math.max(result, sum - min);
			if (evenPositive != (i % 2 == 0)) min = Math.min(min, sum);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem2036 problem = new Problem2036();
		System.out.println(problem.maximumAlternatingSubarraySum(new int[] {-1}));
	}
}
