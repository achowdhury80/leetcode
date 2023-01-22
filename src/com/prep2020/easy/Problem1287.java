package com.prep2020.easy;

public class Problem1287 {
	/**
	 * O(N)
	 * @param arr
	 * @return
	 */
	public int findSpecialInteger(int[] arr) {
        int minCount = arr.length / 4 + 1;
        for (int i = 0; i <= arr.length - minCount; i++) {
        	if (arr[i] == arr[i + minCount - 1]) return arr[i];
        }
        return -1;
    }
}
