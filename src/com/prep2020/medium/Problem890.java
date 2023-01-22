package com.prep2020.medium;
import java.util.*;
public class Problem890 {
	/**
	 * *Time Complexity: O(N * K)O(N∗K), where N is the number of words, and K is the 
	 *length of each word. 
	 * Space Complexity: O(N * K)O(N∗K), the space used by the answer.
	 * @param words
	 * @param pattern
	 * @return
	 * @param words
	 * @param pattern
	 * @return
	 */
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> result = new ArrayList<>();
		for (String w : words) {
			Map<Character, Character> map = new HashMap<>();
			boolean flag = true;
			for (int i = 0; i < w.length(); i++) {
				char c1 = w.charAt(i), c2 = pattern.charAt(i);
				if (map.containsKey(c2)) {
					if (map.get(c2) != c1) {
						flag = false;
						break;
					}
				} else {
					if (map.values().contains(c1)) {
						flag = false;
						break;
					}
					map.put(c2, c1);
				}
			}
			if (flag) result.add(w);
		}
		return result;
    }
}
