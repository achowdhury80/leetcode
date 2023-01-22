package com.prep2020.easy;

public class Problem941 {
	/**
	 * O(N)
	 * @param arr
	 * @return
	 */
	public boolean validMountainArray(int[] arr) {
		if (arr.length < 3 || arr[1] <= arr[0]) return false;
		boolean increasing = true;
        for (int i = 2; i < arr.length; i++) {
        	if (arr[i] == arr[i - 1]) return false;
        	if (!increasing && arr[i] > arr[i - 1]) return false;
        	if (arr[i] < arr[i - 1]) increasing = false;
        }
        return !increasing;
    }
}
