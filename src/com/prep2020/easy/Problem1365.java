package com.prep2020.easy;

public class Problem1365 {
	/**
	 * O(N) time and O(1) space
	 * @param nums
	 * @return
	 */
	public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counts = new int[101];
        for (int num : nums) counts[num]++;
        //cumulative count
        for (int i = 1; i < 101; i++) counts[i] += counts[i - 1];
        for (int i = 0; i < nums.length; i++) 
        	if (nums[i] > 0) nums[i] = counts[nums[i] - 1];
        return nums;
    }
}
