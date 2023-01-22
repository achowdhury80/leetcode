package com.prep2020.medium;

public class Problem1081 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public String smallestSubsequence(String s) {
		int[] count = new int[26];
        boolean[] used = new boolean[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        String result = "";
        for (char c : s.toCharArray()) {
        	count[c - 'a']--;
        	if (used[c - 'a']) continue;
        	while (result.length() > 0) {
        		char last = result.charAt(result.length() - 1);
        		if (last == c) break;
        		if (last > c && count[last - 'a'] > 0) {
        			result = result.substring(0, result.length() - 1);
        			used[last - 'a'] = false;
        		} else break;
        	}
        	result += c;
    		used[c - 'a'] = true;
        }
        
        return result;
    }
}
