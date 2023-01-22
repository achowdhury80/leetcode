package com.prep2020.medium;
import java.util.*;
public class Problem320 {
	/**
	 * O(2^n)
	 * @param word
	 * @return
	 */
	public List<String> generateAbbreviations(String word) {
        int n = word.length();
        int max = (int)Math.pow(2, n);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < max; i++) {
        	result.add(findAbbv(word, i));
        }
        return result;
    }

	private String findAbbv(String word, int i) {
		int count = 0, length = word.length();
		String result = "";
		for (int j = length - 1; j > -1; j--) {
			if ((i & (1 << j)) == 0) {
				if (count > 0) {
					result += count;
					count = 0;
				}
				result += word.charAt(length - j - 1);
			} else count++;
		}
		if (count > 0) result += count;
		return result;
	}
}
