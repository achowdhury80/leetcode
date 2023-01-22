package com.prep2020.easy;

public class Problem1417 {
	public String reformat(String s) {
        String letters = "", digits = "";
        for (char c : s.toCharArray()) {
        	if (c >= '0' && c <= '9') digits += c;
        	else letters += c;
        }
        if (Math.abs(letters.length() - digits.length()) > 1) return "";
        String result = "";
        String bigger = letters, smaller = digits;
        if (bigger.length() < smaller.length()) {
        	bigger = digits;
        	smaller = letters;
        }
        int i = 0;
        while(i < smaller.length()) {
        	result += bigger.charAt(i);
        	result += smaller.charAt(i++);
        }
        if (i < bigger.length()) result += bigger.charAt(i);
        return result;
    }
}
