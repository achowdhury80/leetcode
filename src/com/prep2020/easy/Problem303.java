package com.prep2020.easy;

public class Problem303 {
	private int[] sum;
	public Problem303(int[] nums) {
        sum = new int[nums.length];
        if (nums.length > 0) sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) sum[i] = sum[i - 1] + nums[i];
    }
    
    public int sumRange(int i, int j) {
        return sum[j] - (i == 0 ? 0 : sum[i - 1]);
    }
}
