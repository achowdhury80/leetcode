package com.prep2020.medium;

public class Problem280 {
	/**
	 * O(N)
	 * @param nums
	 */
	public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
        	if (i % 2 == 0 && nums[i + 1] < nums[i]) swap(nums, i, i + 1);
        	else if (i % 2 == 1 && nums[i + 1] > nums[i]) swap(nums, i, i + 1);
        }
    }
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
