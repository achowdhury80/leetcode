package com.prep2020.medium;

public class Problem318 {
	/**
	 * O(N * m)
	 * @param words
	 * @return
	 */
	public int maxProduct(String[] words) {
		int n = words.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < words.length; i++) {
        	String w = words[i];
        	arr[i][1] = w.length();
        	arr[i][0] = findLetterMask(w);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if ((arr[i][0] & arr[j][0]) == 0) result = Math.max(result, arr[i][1] * arr[j][1]);
        	}
        }
        return result;
    }
	
	private int findLetterMask(String w) {
		int result = 0;
		for (char c : w.toCharArray()) result |= (1 << (c - 'a'));
		return result;
	}
}
