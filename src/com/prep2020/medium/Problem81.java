package com.prep2020.medium;

public class Problem81 {
	/**
	 * O(N) time
	 * trick -> nums[mid] > nums[high]
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean search(int[] nums, int target) {
		if (nums.length < 1) return false;
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) return true;
			if (nums[mid] > nums[high]) {
				if (target <= nums[high] || target > nums[mid]) low = mid + 1;
				else high = mid - 1;
			} else if (nums[mid] == nums[high]) high--;
			else {
				if (target > nums[high] || target < nums[mid]) high = mid - 1;
				else low = mid + 1;
			}
		}
		return high > -1 && high < nums.length && nums[high] == target;
	}
}
