package com.prep2020.medium;

public class Problem34 {
	/**
	 * O(logN)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] searchRange(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		int[] result = new int[] {-1, -1};
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				result[0] = findMinIndex(nums, low, mid);
				result[1] = findMaxIndex(nums, mid, high);
				break;
			} else if (nums[mid] < target) low = mid + 1;
			else high = mid - 1;
		}
		return result;
	}
	
	private int findMinIndex(int[] nums, int low, int high) {
		int num = nums[high];
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == num) high = mid;
			else low = mid + 1;
		}
		return high;
	}
	
	private int findMaxIndex(int[] nums, int low, int high) {
		int num = nums[low], result = low;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == num) {
				result = mid;
				low = mid + 1;
			}
			else high = mid - 1;
		}
		return result;
	}
}
