package com.prep2020.medium;

public class Problem1375 {
	/**
	 * O(N)
	 * @param light
	 * @return
	 */
	public int numTimesAllBlue(int[] light) {
        int maxValue = -1;
        int result = 0;
        for (int i = 0; i < light.length; i++) {
        	maxValue = Math.max(maxValue, light[i]);
        	if (maxValue == i + 1) result++;
        }
        return result;
    }
}
