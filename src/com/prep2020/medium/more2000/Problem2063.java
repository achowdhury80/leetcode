package com.prep2020.medium.more2000;

public class Problem2063 {
	public long countVowels(String word) {
        int n = word.length();
        long  result = 0;
        for (int i = 0; i < n; i++) {
        	char c = word.charAt(i);
        	if ("aeiou".indexOf(c) > -1) result += (n + (i * (n - i - 1 + 0l)));
        }
        return result;
    }
}
