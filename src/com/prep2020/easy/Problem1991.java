package com.prep2020.easy;

public class Problem1991 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        int leftSum = 0, rightSum = sum;
        for (int i = 0; i < nums.length; i++) {
        	leftSum += (i == 0 ? 0 : nums[i - 1]);
        	rightSum = sum - (leftSum + nums[i]);
        	if (leftSum == rightSum) return i;
        }
        return -1;
    }
}
