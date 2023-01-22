package com.prep2020.easy;

public class Problem2000 {
	public String reversePrefix(String word, char ch) {
		int index = -1;
        if ((index = word.indexOf(ch)) < 0) return word;
        return new StringBuilder(word.substring(0, index + 1)).reverse().toString() 
        		+ word.substring(index + 1);
    }
}
