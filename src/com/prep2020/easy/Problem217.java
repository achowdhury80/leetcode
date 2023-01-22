package com.prep2020.easy;

import java.util.Arrays;

public class Problem217 {
	/**
	 * O(NlogN)
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) if (nums[i] == nums[i - 1]) return true;
        return false;
    }
}
