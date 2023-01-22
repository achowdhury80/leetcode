package com.prep2020.easy;

public class Problem2287 {
	public int rearrangeCharacters(String s, String target) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) targetCount[c - 'a']++;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
        	if (targetCount[i] == 0) continue;
        	result = Math.min(result, count[i] / targetCount[i]);
        }
        return result;
    }
}
