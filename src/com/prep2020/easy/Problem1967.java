package com.prep2020.easy;

public class Problem1967 {
	public int numOfStrings(String[] patterns, String word) {
        int result = 0;
        for (String p : patterns) {
        	if (word.indexOf(p) > -1) result++;
        }
        return result;
    }
}
