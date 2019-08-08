package com.leet.algo;

public class Prob1119 {
	public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
        	if ("aeiou".indexOf(c) < 0) {
        		sb.append(c);
        	}
        }
        return sb.toString();
    }
}
