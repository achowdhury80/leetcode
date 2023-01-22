package com.prep2020.hard;

public class Problem45 {
	/**
	 * O(N) time and O(1) space
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int jump = 1, maxSoFar = nums[0], max = nums[0];
        for (int i = 1; i < n; i++) {
        	if (i > maxSoFar) {
        		jump++;
        		maxSoFar = max;
        	}
        	max = Math.max(max, i + nums[i]);
        }
        return jump;
    }
}
