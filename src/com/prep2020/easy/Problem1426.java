package com.prep2020.easy;

public class Problem1426 {
	/**
	 * O(N)
	 * @param arr
	 * @return
	 */
	public int countElements(int[] arr) {
        int[] counts = new int[1001];
        for (int a : arr) counts[a]++;
        int result = 0;
        for (int i = 0; i < 1000; i++) {
        	if (counts[i + 1] > 0) result += counts[i];
        }
        return result;
    }
}
