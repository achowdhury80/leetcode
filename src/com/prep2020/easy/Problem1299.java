package com.prep2020.easy;
public class Problem1299 {
	/**
	 * O(N)
	 * @param arr
	 * @return
	 */
	public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i > -1; i--) {
        	int temp = arr[i];
        	arr[i] = max;
        	max = Math.max(max, temp);
        }
        return arr;
    }
}
