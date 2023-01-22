package com.prep2020.easy;

import java.util.Arrays;

public class Problem1033 {
	/*
	 * O(1)
	 */
	public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[] {a, b, c};
        Arrays.sort(arr);
        int[] result = new int[2];
        if (arr[1] - arr[0] == 2 || arr[2] - arr[1] == 2) result[0] = 1;
        else {
        	if (arr[1] - arr[0] > 1) result[0]++;
        	if (arr[2] - arr[1] > 1) result[0]++;
        }
        result[1] = (arr[2] - arr[0] - 2);
        return result;
    }
}
