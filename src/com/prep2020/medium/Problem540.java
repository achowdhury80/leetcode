package com.prep2020.medium;

public class Problem540 {
	public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high) {
        	int mid = low + (high - low) / 2;
        	if (mid % 2 == 1) {
        		if (nums[mid - 1] == nums[mid]) low = mid + 1;
        		else {
        			if (nums[mid + 1] == nums[mid]) high = mid - 1;
        			else return nums[mid];
        		}
        	} else {
        		if (nums[mid] == nums[mid + 1]) low = mid + 2;
        		else if (nums[mid] == nums[mid - 1]) high = mid -2;
        		else return nums[mid];
        	}
        }
        return nums[low];
    }
}
