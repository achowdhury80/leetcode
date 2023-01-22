package com.prep2020.medium;

public class Problem1456 {
	/**
	 * O(N)
	 * @param s
	 * @param k
	 * @return
	 */
	public int maxVowels(String s, int k) {
        int result = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if ("aeiou".indexOf(c) > -1) count++;
        	if (i >= k && "aeiou".indexOf(s.charAt(i - k)) > -1) count--;
        	result = Math.max(result, count);
        }
        return result;
    }
}
