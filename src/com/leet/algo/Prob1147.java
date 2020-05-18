package com.leet.algo;

public class Prob1147 {
	public int longestDecomposition(String text) {
        char[] arr = text.toCharArray();
        return longestDecomposition(arr, 0, arr.length - 1);
    }
	
	private int longestDecomposition(char[] arr, int i, int j) {
		if (i == j) return 1;
		for (int k = i; k - i + 1 <= j - k; k++) {
			if (arr[k] == arr[j]) {
				
			}
		}
		return 0;
	}
	
	
}
