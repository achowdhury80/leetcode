package com.prep2020.medium;

import java.util.Arrays;

public class Problem1846 {
	/**
	 * O(nlogN)
	 * @param arr
	 * @return
	 */
	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int result = 1;
        for (int i = 1; i < arr.length; i++) {
        	if (arr[i] > result + 1) {
        		result++;
        	} else result = arr[i];
        }
        return result;
    }
}
