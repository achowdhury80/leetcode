package com.prep2020.easy;

public class Problem1796 {
	public int secondHighest(String s) {
        boolean[] arr = new boolean[10];
        for (char c : s.toCharArray()) {
        	if (Character.isDigit(c)) {
        		arr[c - '0'] = true;
        	}
        }
        
        int result = -1;
        boolean firstFound = false;
        for (int i = 9; i > -1; i--) {
        	if (arr[i]) {
        		if (firstFound) return i;
        		else firstFound = true;
        	}
        }
        return result;
    }
}
