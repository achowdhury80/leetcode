package com.prep2020.medium;

import java.util.Arrays;

public class Problem611 {
	/**
	 * O(n^2)
	 * @param nums
	 * @return
	 */
	public int triangleNumber(int[] nums) {
		int n = nums.length;
        Arrays.sort(nums);
        int result = 0;
        for (int i = n - 1; i > 1; i--) {
        	int low = 0, high = i - 1;
        	while (low < high) {
        		if (nums[low] + nums[high] > nums[i]) {
        			result += high - low;
        			high--;
        		} else low++;
        	}
        }
        return result;
    }
}
