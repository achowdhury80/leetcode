package com.prep2020.medium.more2000;

public class Problem5951 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public long numberOfSubstrings(String s) {
        long result = s.length();
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
        	arr[c - 'a']++;
        }
        for (int i : arr) {
        	if (i > 1) result += ((i - 1l) * i) / 2;
        }
        return result;
    }
}
