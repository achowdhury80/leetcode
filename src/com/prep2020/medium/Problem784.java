package com.prep2020.medium;
import java.util.*;
public class Problem784 {
	/**
	 * O(2^N)
	 * @param s
	 * @return
	 */
	public List<String> letterCasePermutation(String s) {
		List<String> result = new ArrayList<>();
		result.add("");
		for (char c : s.toCharArray()) {
			List<Character> newChars = new ArrayList<>();
			if (c >= '0' && c <= '9') newChars.add(c);
			else {
				newChars.add(Character.toLowerCase(c));
				newChars.add(Character.toUpperCase(c));
			}
			List<String> temp = new ArrayList<>();
			for (String s1 : result) {
				for (char newChar : newChars) temp.add(s1 + newChar);
			}
			result = temp;
		}
		return result;
    }
}
