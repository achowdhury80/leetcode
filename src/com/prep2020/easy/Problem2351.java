package com.prep2020.easy;

public class Problem2351 {
	public char repeatedCharacter(String s) {
        boolean[] arr = new boolean[26];
        for (char c : s.toCharArray()) {
        	if (arr[c - 'a']) return c;
        	arr[c - 'a'] = true;
        }
        return 'a';
    }
}
