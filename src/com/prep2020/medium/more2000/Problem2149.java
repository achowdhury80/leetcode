package com.prep2020.medium.more2000;

public class Problem2149 {
	/**
	 * no O(n) in place solution
	 * o(n) if we add O(n) space
	 * @param nums
	 * @return
	 */
	public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n / 2], neg = new int[n / 2];
        int i = 0, j = 0;
        for (int num : nums) {
        	if (num > 0) pos[i++] = num;
        	else neg[j++] = num;
        }
        for (int k = 0; k < n; k++) {
        	if (k % 2 == 0) nums[k] = pos[k / 2];
        	else nums[k] = neg[k / 2];
        }
        return nums;
    }
}
