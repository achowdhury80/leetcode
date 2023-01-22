package com.prep2020.easy;

public class Problem1941 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public boolean areOccurrencesEqual(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
        	arr[c - 'a']++;
        }
        int count = arr[0];
        for (int i = 0; i < 26; i++) {
        	if (arr[i] != 0) {
        		if (count == 0) count = arr[i];
        		else if (count != arr[i]) return false;
        	}
        }
        return true;
    }
}
