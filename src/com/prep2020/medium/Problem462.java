package com.prep2020.medium;

import java.util.Arrays;

public class Problem462 {
	/**
	 * O(NlogN)
	 * @param nums
	 * @return
	 */
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int result = 0, i = 0, j = nums.length - 1;
		while(i < j) result += (nums[j--] - nums[i++]);
        return result;
    }
}
