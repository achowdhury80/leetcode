package com.prep2020.medium;

public class Problem477 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int totalHammingDistance(int[] nums) {
		int n = nums.length, result = 0;
		for (int i = 0; i < 32; i++) {
        	int ones = 0;
        	for (int num : nums) {
        		if (((num >> i) & 1) > 0) ones++;
        	}
        	result += ones * (n - ones);
        }
        
        return result;
    }
}
