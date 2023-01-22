package com.prep2020.medium;

public class Problem1347 {
	/**
	 * O(N)
	 * @param s
	 * @param t
	 * @return
	 */
	public int minSteps(String s, String t) {
        int[] charMap = new int[26];
        for (char c : s.toCharArray()) {
        	charMap[c - 'a']++;
        }
        int result = s.length();
        for (char c : t.toCharArray()) {
        	if (charMap[c - 'a'] > 0) {
        		result--;
        		charMap[c - 'a']--;
        	}
        }
        return result;
    }
}
