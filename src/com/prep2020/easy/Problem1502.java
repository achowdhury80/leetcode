package com.prep2020.easy;

import java.util.Arrays;

public class Problem1502 {
	/**
	 * o(nlogn) 
	 * or O(N) time and space 
	 * @param arr
	 * @return
	 */
	public boolean canMakeArithmeticProgression(int[] arr) {
		if (arr.length < 3) return true; 
        Arrays.sort(arr);
        for (int i = 2; i < arr.length; i++) {
        	if (arr[i] - arr[i - 1] != arr[i - 1] - arr[i - 2]) return false;
        }
        return true;
    }
}
