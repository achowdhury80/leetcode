package com.prep2020.medium.more2000;

public class Problem2216 {
	public int minDeletion(int[] nums) {
        int result = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
        	if (i == n - 1) result++;
        	else {
        		if (nums[i] == nums[i + 1]) {
        			result++;
        			continue;
        		} else i++;
        	}
        }
        return result;
    }
}
