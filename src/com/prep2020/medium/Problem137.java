package com.prep2020.medium;

public class Problem137 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
        	int ones = 0;
        	for (int num : nums) if (((num >> i) & 1) > 0) ones++;
        	if (ones % 3 != 0) result ^= (1 << i);
        }
        
        return result;
    }
}
