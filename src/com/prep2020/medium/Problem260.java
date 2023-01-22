package com.prep2020.medium;

public class Problem260 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int[] singleNumber(int[] nums) {
        int xored = 0;
        for (int num : nums) xored ^= num;
        int diffPos = -1;
        for (int i = 0; i < 32; i++) {
        	if (((xored >> i) & 1) > 0) {
        		diffPos = i;
        		break;
        	}
        }
        
        int[] result = new int[2];
        
        for (int num : nums) {
        	if (((num >> diffPos) & 1) > 0) result[1] ^= num;
        	else result[0] ^= num;
        }
        
        return result;
    }
}
