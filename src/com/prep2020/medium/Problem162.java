package com.prep2020.medium;

public class Problem162 {
	/**
	 * O(LogN)
	 * @param nums
	 * @return
	 */
	public int findPeakElement(int[] nums) {
		int n = nums.length;
        int low = 0, high = n - 1;
        while(low < high) {
        	int mid = low + (high - low) / 2;
        	if ((mid == 0 || nums[mid] > nums[mid - 1]) 
        			&& (mid == n - 1 || nums[mid] > nums[mid + 1])) return mid;
        	if (mid > 0 && nums[mid] < nums[mid - 1]) high = mid - 1;
        	else if (mid < n - 1 && nums[mid] < nums[mid + 1]) low = mid + 1;
        }
        return low;
    }
}
