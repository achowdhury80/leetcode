package com.prep2020.easy;

import java.util.Arrays;

public class Problem748 {
	/*
	 * 
	 */
	public String shortestCompletingWord(String licensePlate, String[] words) {
		int[] arr = new int[26];
		int count = 0;
        for (char c : licensePlate.toCharArray()) {
        	c = Character.toLowerCase(c);
        	if (c >= 'a' && c <= 'z') {
        		arr[c - 'a']++;
        		count++;
        	}
        }
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        for (String w : words) {
        	if (count > w.length()) continue;
        	if (isCompelting(w, arr)) return w;
        }
        return "";
    }

	private boolean isCompelting(String w, int[] arr) {
		int[] charMap = new int[26];
		for (char c : w.toCharArray()) {
			charMap[c - 'a']++;
		}
		
		for (int i = 0; i < 26; i++) {
			if (arr[i] > charMap[i]) return false;
		}
		return true;
	}
}
