package com.prep2020.easy;

public class Problem2283 {
	public boolean digitCount(String num) {
        int[] arr = new int[10];
        for (char c : num.toCharArray()) arr[c - '0']++;
        for (int i = 0; i < num.length(); i++) {
        	if (arr[i] != num.charAt(i) - '0') return false;
        }
        return true;
    }
}
