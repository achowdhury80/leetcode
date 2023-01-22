package com.prep2020.hard;

public class Problem154 {
	/**
	 * O(N) time
	 * @param nums
	 * @return
	 */
	public int findMin(int[] nums) {
		int l = 0, h = nums.length - 1;
		while(l + 1 < h) {
			int mid = l + (h - l) / 2;
			if (nums[mid] > nums[h]) l = mid + 1;
			else if (nums[mid] < nums[l]) h = mid;
			else if (nums[mid] == nums[h]) h--;
			else if (nums[mid] == nums[l]) l++;
			else h = mid - 1;
		}
        return Math.min(nums[l], nums[h]);
    }
}
