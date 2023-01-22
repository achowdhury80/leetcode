package com.prep2020.easy;

public class Problem1122 {
	/**
	 * O(N) time and space
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int i : arr1) count[i]++;
        int idx = 0;
        for (int num : arr2) {
        	for (int j = 0; j < count[num]; j++) {
        		arr1[idx++] = num;
        	}
        	count[num] = 0;
        }
        for (int i = 0; i < 1001; i++) {
        	if (count[i] > 0) {
        		for (int j = 0; j < count[i]; j++) {
            		arr1[idx++] = i;
            	}
        	}
        }
        return arr1;
    }
}
