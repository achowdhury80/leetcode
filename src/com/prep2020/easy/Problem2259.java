package com.prep2020.easy;

public class Problem2259 {
	public String removeDigit(String number, char digit) {
        int lastPos = -1, n = number.length();
        for (int i = 0; i < n; i++) {
        	if (number.charAt(i) == digit) {
        		lastPos = i;
        		if (i < n - 1 && number.charAt(i) < number.charAt(i + 1)) {
        			return number.substring(0, i) + number.substring(i + 1);
        		}
        	}
        }
        return number.substring(0, lastPos) + number.substring(lastPos + 1);
    }
}
