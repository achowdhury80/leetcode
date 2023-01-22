package com.prep2020.medium;

public class Problem189 {
	/**
	 * O(N)
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0) return;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
	
	private void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
