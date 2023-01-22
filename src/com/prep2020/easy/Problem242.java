package com.prep2020.easy;

public class Problem242 {
	/**
	 * O(N)
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        for (char c : s.toCharArray()) arr[c - 'a']++;
        for (char c : t.toCharArray()) {
        	if (arr[c - 'a'] == 0) return false;
        	arr[c - 'a']--;
        }
        return true;
    }
}
