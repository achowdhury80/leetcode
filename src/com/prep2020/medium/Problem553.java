package com.prep2020.medium;

public class Problem553 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public String optimalDivision(int[] nums) {
        if (nums.length == 1) return "" + nums[0];
        if (nums.length == 2) return nums[0] + "/" + nums[1];
        String result = nums[0] + "/(" + nums[1];
        for (int i = 2; i < nums.length; i++) result += "/" + nums[i];
        result += ")";
        return result;
    }
}
