package com.prep2020.easy;

public class Problem2114 {
	public int mostWordsFound(String[] sentences) {
        int result = 0;
        for (String s : sentences) {
        	String[] words = s.split(" ");
        	result = Math.max(result, words.length);
        }
        return result;
    }
}
