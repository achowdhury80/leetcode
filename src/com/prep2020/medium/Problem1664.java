package com.prep2020.medium;

public class Problem1664 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int waysToMakeFair(int[] nums) {
		int n = nums.length;
		if (n == 1) return 1;
		// sums[i] is the the sum of all elements starting from index i 
		//and skipping the next element and so on.
        int[] sums = new int[n + 2];
        for (int i = n - 1; i > 0; i--) {
        	sums[i] = nums[i] + sums[i + 2];
        }
        int evenSum = 0, oddSum = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
        	if (i % 2 == 0) {
        		if (evenSum + sums[i + 1] == oddSum + sums[i + 2]) result++;
        		evenSum += nums[i];
        	} else {
        		if (oddSum + sums[i + 1] == evenSum + sums[i + 2]) result++;
        		oddSum += nums[i];
        	}
        }
        return result;
    }
}
