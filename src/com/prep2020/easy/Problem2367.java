package com.prep2020.easy;

public class Problem2367 {
	public int arithmeticTriplets(int[] nums, int diff) {
        boolean[] arr = new boolean[201];
        for (int i : nums) arr[i] = true;
        int result = 0;
        for (int i = 0; i < 199; i++) {
        	if (arr[i] && (i + diff) < 201 && arr[i + diff] && (i + 2 * diff) < 201 && arr[i + 2 * diff]) result++;
        }
        return result;
    }
}
