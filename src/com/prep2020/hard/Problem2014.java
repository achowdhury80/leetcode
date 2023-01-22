package com.prep2020.hard;
import java.util.*;
public class Problem2014 {
	/**
	 * time = n * 2 ^ 8, where n = s.length();
	 *      n = cost of isValid
	 *      2 ^ 8 = cost of helper function, 8 is the max length of validChars, how?
	 *          note the constraints n < k * 8, so n / k < 8, assume k = 3, so max n < 24
	 *          in this case we let n = 24
	 *          imagine s = "aaabbbcccdddeeefffggghhh", we collect all characters into
	 *          validChars, and the length of validChars = 8
	 */
	public String longestSubsequenceRepeatedK(String s, int k) {
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		ArrayList<Character> validChars = new ArrayList<>();
		for (char i = 'z'; i >= 'a'; i--) {
			if (count[i - 'a'] >= k)
				validChars.add(i); // collect only the valid characters
		}
		return helper(s, k, 0, "", validChars);
	}

	// path here is the subSequence
	private String helper(String s, int k, int idx, String path, ArrayList<Character> validChars) {
		if (validChars.size() == idx) {
			return path;
		} else {
			String include = "";
			if (isValid(s, path + validChars.get(idx), k)) { // only add char to path if it's valid
				include = helper(s, k, 0, path + validChars.get(idx), validChars);
			}
			String exclude = helper(s, k, idx + 1, path, validChars);
			return include.length() >= exclude.length() ? include : exclude;
		}
	}

	private boolean isValid(String s, String sub, int k) {
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.length() - i < sub.length() * k - j)
				return false; // return early if characters left in s is not enough to satisfy the condition
			if (s.charAt(i) == sub.charAt(j)) {
				j++;
				if (j == sub.length()) {
					j = 0;
					k--;
					if (k == 0)
						return true;
				}
			}
		}
		return false;
	}
}
