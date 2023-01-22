package com.prep2020.medium;

import java.util.Arrays;

public class Problem1079 {
	/**
	 * o(n!)
	 * @param tiles
	 * @return
	 */
	public int numTilePossibilities(String tiles) {
		int[] result = new int[] {0};
		char[] arr = tiles.toCharArray();
		Arrays.sort(arr);
        helper(arr, 0, result);
        return result[0];
    }
	
	private void helper(char[] arr, int used, int[] result) {
		if (used != 0) result[0]++;
		if (used ==  (1 << arr.length) - 1) return;
		for (int i = 0; i < arr.length; i++) {
			if (((1 << i) & used) > 0 || (i > 0 && arr[i - 1] == arr[i] && (((1 << (i - 1)) & used) == 0))) continue;
			helper(arr, used | (1 << i), result);
		}
	}
}
