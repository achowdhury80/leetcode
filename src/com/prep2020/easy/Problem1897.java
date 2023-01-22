package com.prep2020.easy;

public class Problem1897 {
	/**
	 * O(N)
	 * @param words
	 * @return
	 */
	public boolean makeEqual(String[] words) {
        int n = words.length;
        int[] count = new int[26];
        for (String w : words) {
        	for (char c : w.toCharArray()) count[c - 'a']++;
        }
        for (int i : count) if (i % n != 0) return false;
        return true;
    }
}
