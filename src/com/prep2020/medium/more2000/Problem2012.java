package com.prep2020.medium.more2000;

public class Problem2012 {
	/**
	 * O(n0 time and space
	 * @param nums
	 * @return
	 */
	public int sumOfBeauties(int[] nums) {
		int n = nums.length;
        int[] mins = new int[n];
        mins[n - 1] = nums[n - 1];
        for (int i = n - 2; i > -1; i--) mins[i] = Math.min(mins[i + 1], nums[i]);
        int max = nums[0], result = 0;
        for (int i = 1; i < n - 1; i++) {
        	if (max < nums[i] && nums[i] < mins[i + 1]) result += 2;
        	else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) result += 1;
        	max = Math.max(max, nums[i]);
        }
        return result;
    }
}
