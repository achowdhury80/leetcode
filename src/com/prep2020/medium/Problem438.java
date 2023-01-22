package com.prep2020.medium;
import java.util.*;
public class Problem438 {
	/**
	 * O(N)
	 * @param s
	 * @param p
	 * @return
	 */
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int[] chars = new int[26];
		for (char c : p.toCharArray()) chars[c - 'a']++;
		int count = p.length();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			chars[c - 'a']--;
			if (chars[c - 'a'] > -1) count--;
			if (i >= p.length() ) {
				char rem = s.charAt(i - p.length());
				chars[rem - 'a']++;
				if (chars[rem - 'a'] > 0) count++;
			}
			if (count == 0) result.add(i - p.length() + 1);
		}
		return result;
    }
}
