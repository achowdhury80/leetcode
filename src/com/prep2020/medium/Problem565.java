package com.prep2020.medium;

public class Problem565 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int arrayNesting(int[] nums) {
		int n = nums.length;
        boolean[] used = new boolean[n];
        int result = 1;
        for (int i = 0; i < n; i++) {
        	if (used[nums[i]]) continue;
        	int count = findLoopSize(nums, used, i);
        	result = Math.max(result, count);
        }
        return result;
    }

	private int findLoopSize(int[] nums, boolean[] used, int i) {
		int result = 0;
		while(!used[nums[i]]) {
			result++;
			used[nums[i]] = true; 
			i = nums[i];
		}
		return result;
	}
}
