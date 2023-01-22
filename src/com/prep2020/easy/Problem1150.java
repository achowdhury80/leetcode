package com.prep2020.easy;

public class Problem1150 {
	public boolean isMajorityElement(int[] nums, int target) {
        int len = nums.length;
        int mid = len / 2;
        if (nums[mid] != target) return false;
        if (len == 1) return true;
        int start = 0, end = mid;
        while(start < end) {
        	int m = start + (end - start) / 2;
        	if (nums[m] == target) end = m;
        	else start = m + 1;
        }
        int low = start;
        start = mid; 
        end = len - 1;
        while(start < end) {
        	int m = start + (end - start) / 2;
        	if (nums[m] == target) {
        		start = m;
        		if (nums[start + 1] == target) start++;
        		else break;
        	}
        	else end = m - 1;
        }
        return (start - low + 1) >= len / 2 + 1;
        
    }
}
