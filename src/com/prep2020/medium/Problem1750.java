package com.prep2020.medium;

public class Problem1750 {
	/**
	 * O(n)
	 * @param s
	 * @return
	 */
	public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
        	if (s.charAt(i) != s.charAt(j)) break;
        	int prefixLast = i, suffixStart = j;
        	for (int k = i + 1; k < j && s.charAt(k) == s.charAt(i); k++) {
        		prefixLast = k;
        	}
        	for (int k = j - 1; k > i && s.charAt(k) == s.charAt(j); k--) {
        		suffixStart = k;
        	}
        	if (prefixLast >= suffixStart) return 0;
        	i = prefixLast + 1;
        	j = suffixStart - 1;
        }
        return j - i + 1;
    }
}
