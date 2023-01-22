package com.prep2020.easy;

public class Problem35 {
	/**
	 * O(nlogn)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
        	int mid = i + (j - i) / 2;
        	if (nums[mid] == target) return mid;
        	if (nums[mid] > target) j = mid - 1;
        	else i = mid + 1;
        }
        if (i == nums.length) return i;
        if (nums[i] < target) return i + 1;
        return i;
    }
}
