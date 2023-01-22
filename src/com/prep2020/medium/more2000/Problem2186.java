package com.prep2020.medium.more2000;

public class Problem2186 {
	/**
	 * O(n)
	 * @param s
	 * @param t
	 * @return
	 */
	public int minSteps(String s, String t) {
        int[] arr1 = new int[26], arr2 = new int[26];
        for (char c : s.toCharArray()) arr1[c - 'a']++;
        for (char c : t.toCharArray()) arr2[c - 'a']++;
        int result = 0;
        for (int i = 0; i < 26; i++) result += Math.abs(arr1[i] - arr2[i]);
        return result;
    }
}
