package com.prep2020.medium;

public class Problem1746 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int maxSumAfterOperation(int[] nums) {
        int result = Integer.MIN_VALUE;
        int notUsed = 0, used = 0;
        for (int num : nums) {
        	used = Math.max(used + num, notUsed + num * num);
        	result = Math.max(result, used);
        	if (notUsed + num > 0) notUsed += num;
        	else notUsed = 0;
        }
        return result;
    }
}
