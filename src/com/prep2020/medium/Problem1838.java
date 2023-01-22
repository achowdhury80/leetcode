package com.prep2020.medium;

import java.util.Arrays;

public class Problem1838 {
	/**
	 * O(N)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int maxFrequency(int[] nums, int k) {
		Arrays.sort(nums);
        int result = 1, start = 0, used = 0;
        for (int i = 1; i < nums.length; i++) {
        	used += (i - start) * (nums[i] - nums[i - 1]);
        	while(used > k) {
        		used -= nums[i] - nums[start++];
        	}
        	result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
 