package com.prep2020.medium;

public class Problem1829 {
	/**
	 * O(N * maxBit)
	 * @param nums
	 * @param maximumBit
	 * @return
	 */
	public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0, n = nums.length;
        for (int num : nums) xor ^= num;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
        	result[i] = findK(xor, maximumBit);
        	xor ^= nums[n - 1 - i];
        }
        return result;
    }
	
	private int findK(int num, int maxBit) {
		int result = 0;
		for (int i = 0; i < maxBit; i++) {
			if ((num & (1 << i)) == 0) result |= (1 << i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem1829 problem = new Problem1829();
		System.out.println(problem.getMaximumXor(new int[] {0,1,1,3}, 2));
	}
}
