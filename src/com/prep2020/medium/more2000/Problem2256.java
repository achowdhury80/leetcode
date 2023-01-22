package com.prep2020.medium.more2000;

public class Problem2256 {
	public int minimumAverageDifference(int[] nums) {
        long rightSum = 0, diff = Long.MAX_VALUE, leftSum = 0;
        int result = -1;
        for (int n : nums) rightSum += n;
        for (int i = 0; i < nums.length; i++) {
        	leftSum += nums[i];
        	rightSum -= nums[i];
        	long leftAvg = leftSum / (i + 1);
        	long rightAvg = rightSum == 0 ? 0 : (rightSum / (nums.length - i - 1));
        	if (diff > Math.abs(leftAvg - rightAvg)) {
        		diff = Math.abs(leftAvg - rightAvg);
        		result = i;
        	}
        }
        return result;
    }
}
