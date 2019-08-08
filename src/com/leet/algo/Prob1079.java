package com.leet.algo;

import java.util.Arrays;

public class Prob1079 {
	public int numTilePossibilities(String tiles) {
        int[] result = new int[] {0};
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        numTilePossibilities(arr, 0, result);
        return result[0];
    }
	
	private void numTilePossibilities(char[] arr, int taken, int[] result) {
		if (taken ==  (1 << arr.length) - 1) return;
		for (int i = 0; i < arr.length; i++) {
			if ((taken & (1 << i)) > 0 || (i > 0 && arr[i] == arr[i - 1] && (taken & (1 << i - 1)) == 0)) continue;
			taken |= (1 << i);
			result[0]++;
			numTilePossibilities(arr, taken, result);
			taken ^= (1 << i);
		}
	}
	
	
}
