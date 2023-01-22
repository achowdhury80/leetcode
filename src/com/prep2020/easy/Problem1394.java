package com.prep2020.easy;

public class Problem1394 {
	/**
	 * O(1)
	 * @param arr
	 * @return
	 */
	public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int i : arr) count[i]++;
        for (int i = 500; i > 0; i--) if (count[i] == i) return i;
        return -1;
    }
}
