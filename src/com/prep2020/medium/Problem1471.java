package com.prep2020.medium;

import java.util.Arrays;

public class Problem1471 {
	/**
	 * O(nlogn)
	 * @param arr
	 * @param k
	 * @return
	 */
	public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int medianIndex = (arr.length - 1) / 2;
        int[] result = new int[k];
        int idx = 0, left = 0, right = arr.length - 1;
        while(idx < k) {
        	if (arr[medianIndex] - arr[left] > arr[right] - arr[medianIndex]) {
        		result[idx++] = arr[left++];
        	} else result[idx++] = arr[right--];
        }
        return result;
    }
}
