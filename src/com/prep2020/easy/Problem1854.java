package com.prep2020.easy;

public class Problem1854 {
	/**
	 * O(N) time and space
	 * @param logs
	 * @return
	 */
	public int maximumPopulation(int[][] logs) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] log : logs) {
        	min = Math.min(min, log[0]);
        	max = Math.max(max, log[1]);
        }
        int[] arr = new int[max - min + 1];
        for (int[] log : logs) {
        	arr[log[0] - min]++;
        	arr[log[1] - min]--;
        }
        int[] result = new int[] {0, Integer.MIN_VALUE};
        int cur = 0;
        for (int i = 0; i < arr.length - 1; i++) {
        	cur += arr[i];
        	if (cur > result[1]) {
        		result = new int[] {min + i, cur};
        	}
        }
        return result[0];
    }
}
