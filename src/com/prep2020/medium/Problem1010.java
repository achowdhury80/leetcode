package com.prep2020.medium;

public class Problem1010 {
	/**
	 * O(N)
	 * @param time
	 * @return
	 */
	public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        for (int t : time) arr[t % 60]++;
        int result = 0;
        for (int i = 1; i < 30; i++) {
        	result += arr[i] * arr[60 - i];
        }
        result += arr[0] * (arr[0] - 1) / 2;
        result += arr[30] * (arr[30] - 1) / 2;
        return result;
    }
}
