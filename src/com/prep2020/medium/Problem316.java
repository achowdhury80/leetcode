package com.prep2020.medium;

public class Problem316 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public String removeDuplicateLetters(String s) {
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
	
	public static void main(String[] args) {
		Problem316 problem = new Problem316();
		System.out.println(problem.removeDuplicateLetters("bcabc"));
		System.out.println(problem.removeDuplicateLetters("cbacdcbc"));
	}
}
