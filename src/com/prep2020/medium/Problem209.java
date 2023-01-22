package com.prep2020.medium;

public class Problem209 {
	/**
	 * O(N)
	 * @param target
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen(int target, int[] nums) {
		int sum = 0, start = 0;
		int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	while(sum - nums[start] >= target) {
        		sum -= nums[start];
        		start++;
        	}
        	if (sum >= target) result = Math.min(result, i - start + 1);
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
