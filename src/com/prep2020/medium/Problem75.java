package com.prep2020.medium;

public class Problem75 {
	/**
	 * O(N)
	 * @param nums
	 */
	public void sortColors(int[] nums) {
		int eq = 0, smaller = -1, larger = nums.length;
		while(eq < larger) {
			if (nums[eq] < 1) {
				swap(nums, ++smaller, eq);
				eq++;
			} else if (nums[eq] > 1) {
				swap(nums, --larger, eq);
			} else eq++;
		}
    }
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
