package com.prep2020.easy;

public class Problem1684 {
	/**
	 * O(N * W) n = number of words, w = avg width
	 * @param allowed
	 * @param words
	 * @return
	 */
	public int countConsistentStrings(String allowed, String[] words) {
        boolean[] chars = new boolean[26];
        for (char c : allowed.toCharArray()) chars[c - 'a'] = true;
        int result = 0;
        for (String w : words) {
        	boolean consistent = true;
        	for (char c : w.toCharArray()) {
        		if (!chars[c - 'a']) {
        			consistent = false;
        			break;
        		}
        	}
        	if (consistent) result++;
        }
        return result;
    }
}
