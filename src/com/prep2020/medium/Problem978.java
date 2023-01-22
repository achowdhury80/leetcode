package com.prep2020.medium;

public class Problem978 {
	/**
	 * O(N)
	 * @param arr
	 * @return
	 */
	public int maxTurbulenceSize(int[] arr) {
        int result = 1;
        int[] counts = new int[] {1, 1}; // 0th element represents counts with prev being 
        // smaller and vice-versa
        for (int i = 1; i < arr.length; i++) {
        	int temp = counts[0];
        	if (arr[i - 1] < arr[i]) counts[0] = 1 + counts[1];
        	else counts[0] = 1;
        	if (arr[i - 1] > arr[i]) counts[1] = 1 + temp;
        	else counts[1] = 1;
        	result = Math.max(result, Math.max(counts[0], counts[1]));
        }
        return result;
    }
}
