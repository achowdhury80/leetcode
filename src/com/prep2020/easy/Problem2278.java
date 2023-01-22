package com.prep2020.easy;

public class Problem2278 {
	public int percentageLetter(String s, char letter) {
        int n = s.length(), count = 0;
        for (char c : s.toCharArray()) if (c == letter) count++;
        return (count * 100) / n;
    }
}
