package com.prep2020.easy;

public class Problem1566 {
	/**
	 * O(N)
	 * @param arr
	 * @param m
	 * @param k
	 * @return
	 */
	public boolean containsPattern(int[] arr, int m, int k) {
		int count = 0;
        for (int i = 0; i + m < arr.length; i++) {
        	if (arr[i] == arr[i + m]) count++;
        	else count = 0;
        	if (count == m * (k - 1)) return true;
        }
        return false;
    }
}
