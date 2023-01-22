package com.prep2020.easy;

public class Problem2185 {
	public int prefixCount(String[] words, String pref) {
        int result = 0;
        for (String w : words) {
        	if (w.startsWith(pref)) result++;
        }
        return result;
    }
}
