package com.prep2020.medium;

public class Problem1685 {
	/**
	 * O(N) time and space
	 * @param nums
	 * @return
	 */
	public int[] getSumAbsoluteDifferences(int[] nums) {
		int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) prefixSum[i] = prefixSum[i - 1] + nums[i];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
        	result[i] = (i > 0 ? (i * nums[i]) - prefixSum[i - 1] : 0) + (i < (n - 1) ? ((prefixSum[n - 1] - prefixSum[i]) - (n - i - 1) * nums[i]): 0);
        }
        return result;
    }
}
