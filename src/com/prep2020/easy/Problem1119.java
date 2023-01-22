package com.prep2020.easy;

public class Problem1119 {
	/**
	 * O(N) time
	 * @param S
	 * @return
	 */
	public String removeVowels(String S) {
		StringBuilder result = new StringBuilder();
        for (char c : S.toCharArray()) {
        	if ("aeiou".indexOf(c) < 0) result.append(c);
        }
        return result.toString();
    }
}
