package com.prep2020.medium.more2000;

public class Problem2079 {
	/**
	 * O(N)
	 * @param plants
	 * @param capacity
	 * @return
	 */
	public int wateringPlants(int[] plants, int capacity) {
		int result = 0, sum = 0;
		for (int i = 0; i < plants.length; i++) {
			if (sum + plants[i] > capacity) {
				result += 2 * i;
				sum = 0;
				i--;
			} else sum += plants[i];
		}
		result += plants.length;
		return result;
    }
}
