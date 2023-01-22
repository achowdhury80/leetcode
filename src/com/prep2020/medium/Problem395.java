package com.prep2020.medium;

public class Problem395 {
	public int longestSubstring(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
        	count[c - 'a']++;
        }
        int i = 0, start = 0, result = 0;
        boolean broken = false;
        while(i < s.length()) {
        	int idx = s.charAt(i) - 'a';
        	if (count[idx] < k) {
        		broken = true;
        		result = Math.max(result, longestSubstring(s.substring(start,
        				i), k));
        		start = i + 1;
        	}
        	i++;
        }
        if (!broken) return s.length();
        result = Math.max(result, longestSubstring(s.substring(start,
				s.length()), k));
        return result;
    }
	
	public static void main(String[] args) {
		Problem395 problem = new Problem395();
		System.out.println(problem.longestSubstring("aaabb", 3));
	}
}
