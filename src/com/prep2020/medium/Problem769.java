package com.prep2020.medium;

public class Problem769 {
	/**
	 * O(N)
	 * @param arr
	 * @return
	 */
	public int maxChunksToSorted(int[] arr) {
		int result = 0, max = -1;
        for (int i = 0; i < arr.length; i++) {
        	max = Math.max(max, arr[i]);
        	if (max == i) result++;
        }
        return result;
    }
}
