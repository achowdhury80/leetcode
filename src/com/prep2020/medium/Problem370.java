package com.prep2020.medium;

public class Problem370 {
	/*
	 * O(N + M)
	 * n is length of array and M is number of updates
	 */
	public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int[] update : updates) {
        	result[update[0]] += update[2];
        	if (update[1] < length - 1) result[update[1] + 1] -= update[2];
        }
        int cur = 0;
        for (int i = 0; i < length; i++) {
        	cur += result[i];
        	result[i] = cur;
        }
        return result;
    }
}
