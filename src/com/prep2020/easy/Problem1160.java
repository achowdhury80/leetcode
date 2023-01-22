package com.prep2020.easy;

public class Problem1160 {
	/**
	 * O(NW)
	 * @param words
	 * @param chars
	 * @return
	 */
	public int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        for (char c : chars.toCharArray()) counts[c - 'a']++;
        int result = 0;
        for (String w : words) {
        	int[] charMap = new int[26];
        	boolean good = true;
        	for (char c : w.toCharArray()) {
        		charMap[c - 'a']++;
        		if (charMap[c - 'a'] > counts[c - 'a']) {
        			good = false;
        			break;
        		}
        	}
        	if (good) result += w.length();
        }
        return result;
    }
}
