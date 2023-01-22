package com.prep2020.easy;

public class Problem1165 {
	/**
	 * O(N) where n is the number of chars in word
	 * @param keyboard
	 * @param word
	 * @return
	 */
	public int calculateTime(String keyboard, String word) {
        int[] pos = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
        	pos[keyboard.charAt(i) - 'a'] = i;
        }
        int result = 0, cur = 0;
        for (char c : word.toCharArray()) {
        	result += Math.abs(pos[c - 'a'] - cur);
        	cur = pos[c - 'a'];
        }
        return result;
    }
}
