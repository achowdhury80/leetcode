package com.prep2020.easy;

public class Problem389 {
	/**
	 * O(n)
	 * @param s
	 * @param t
	 * @return
	 */
	public char findTheDifference(String s, String t) {
        int asciiSum = 0;
        for (char c : t.toCharArray()) asciiSum += c;
        for (char c : s.toCharArray()) asciiSum -= c;
        return (char) asciiSum;
    }
}
