package com.prep2020.medium;

public class Problem55 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxPos = 0, cur = 0;
        while(cur <= maxPos) {
        	maxPos = Math.max(maxPos, cur + nums[cur]);
        	if (maxPos >= n - 1) return true;
        	cur++;
        }
        return false;
    }
}
