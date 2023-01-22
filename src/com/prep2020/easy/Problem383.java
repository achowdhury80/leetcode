package com.prep2020.easy;

public class Problem383 {
	/**
	 * O(m + n)
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
		int count;
		if ((count = ransomNote.length()) < 1) return true;
        int[] arr = new int[26];
        for (char c : ransomNote.toCharArray()) {
        	arr[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
        	if (arr[c - 'a'] > 0) {
        		arr[c - 'a']--;
        		count--;
        		if (count == 0) return true;
        	}
        }
        return false;
    }
}
