package com.prep2020.medium;

public class Problem396 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int maxRotateFunction(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i : nums) sum += i;
        int fVal = 0;
        for (int i = 0; i < n; i++) fVal += i * nums[i];
        int result = fVal;
        for (int i = n - 1; i > 0; i--) {
        	fVal += sum - n * nums[i];
        	result = Math.max(result, fVal);
        }
        return result;
    }
}
