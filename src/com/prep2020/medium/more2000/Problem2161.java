package com.prep2020.medium.more2000;

public class Problem2161 {
	/**
	 * O(n) time and space
	 * @param nums
	 * @param pivot
	 * @return
	 */
	public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int lowIdx = 0, highIdx = n - 1;
        for (int i = 0; i < n; i++) {
        	if (nums[i] < pivot) result[lowIdx++] = nums[i];
        	if (nums[n - i - 1] > pivot) result[highIdx--] = nums[n - i - 1];
        }
        for (int i = lowIdx; i <= highIdx; i++) result[i] = pivot;
        return result;
    }
	
	
}
