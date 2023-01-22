package com.prep2020.medium;

public class Problem152 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int lastMinusProd = 0;
        int result = nums[0], prod = 1;
        for (int i = 0; i < n; i++) {
        	if (nums[i] == 0) {
        		result = Math.max(result, 0);
        		prod = 1;
        		lastMinusProd = 0;
        		continue;
        	}
        	prod *= nums[i];
        	result = Math.max(result, prod);
        	if (prod < 0) {
        		if (lastMinusProd != 0) result = Math.max(result, prod / lastMinusProd);
        		else lastMinusProd = prod;
        	}
        }
        return result;
    }
}
