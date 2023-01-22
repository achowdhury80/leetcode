package com.prep2020.easy;

public class Problem2255 {
	public int countPrefixes(String[] words, String s) {
        int result = 0;
        for (String w : words) {
        	if (w.length() > s.length()) continue;
        	boolean prefix = true;
        	for (int i = 0; i < w.length(); i++) {
        		if (s.charAt(i) != w.charAt(i)) {
        			prefix = false;
        			break;
        		}
        	}
        	if (prefix) result++;
        }
        return result;
    }
}
