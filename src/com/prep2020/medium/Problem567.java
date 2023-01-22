package com.prep2020.medium;

public class Problem567 {
	/**
	 * O(N)
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean checkInclusion(String s1, String s2) {
        int[] chars = new int[26];
        for (char c : s1.toCharArray()) {
        	chars[c - 'a']++;
        }
        int count = s1.length();
        for (int i = 0; i < s2.length(); i++) {
        	char c = s2.charAt(i);
        	chars[c - 'a']--;
        	if (chars[c - 'a'] >= 0) count--;
        	if (i >= s1.length()) {
        		char rem = s2.charAt(i - s1.length());
        		chars[rem - 'a']++;
        		if (chars[rem - 'a'] > 0) count++;
        	}
        	if (count == 0) return true;
        }
        return false;
    }
}
