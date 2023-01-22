package com.prep2020.hard;

import java.util.Arrays;

public class Problem691 {
	public int minStickers(String[] stickers, String target) {
        int[] arr = new int[26];
        for (char c : target.toCharArray()) arr[c - 'a']++;
        int[][] s = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
        	for (char c : stickers[i].toCharArray()) {
        		if (arr[c - 'a'] > 0) s[i][c - 'a']++;
        	}
        }
        int[] result = new int[] {Integer.MAX_VALUE};
        helper(s, arr, 0, 0, target.length(), result);
        return result[0] == Integer.MAX_VALUE ? -1 : result[0];
        
    }

	private void helper(int[][] s, int[] arr, int usedStickers, int start, int remaining, int[] result) {
		int n = s.length;
		if (remaining == 0) {
			result[0] = Math.min(result[0], usedStickers);
			return;
		}
		for (int i = start; i < n; i++) {
			if (i < n - 1) helper(s, arr, usedStickers, i + 1, remaining, result);
			int[] clonedArray = Arrays.copyOf(arr, arr.length);
			int removedLetter = 0;
			if ((removedLetter = canBeUsed(s[i], clonedArray)) > 0) helper(s, clonedArray, usedStickers, i, remaining - removedLetter, result);
		}
	}
	
	private int canBeUsed(int[] s, int[] arr) {
		int removed = 0;
		for (int i = 0; i < s.length; i++) {
			int toRemove = Math.min(arr[i], s[i]);
			removed += toRemove;
			arr[i] -= toRemove;
		}
		return removed;
	}
	
}
