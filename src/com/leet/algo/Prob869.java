package com.leet.algo;

import java.util.Arrays;

public class Prob869 {
	public boolean reorderedPowerOf2(int N) {
        int len = findLength(N);
        char[] arr = sort(N);
        int i = 1;
        int curLength;
        while((curLength = findLength(i)) <= len) {
        	if (curLength == len) {
        		char[] temp = sort(i);
        		boolean matches = true;
        		for (int j = 0; j < arr.length; j++) {
        			if (arr[j] != temp[j]) {
        				matches = false;
        				break;
        			}
        		}
        		if (matches) return true;
        	}
        	i *= 2;
        }
        return false;
    }
	
	private int findLength(int x) {
		return ("" + x).length();
	}
	
	private char[] sort(int x) {
		char[] arr = ("" + x).toCharArray();
		Arrays.sort(arr);
		return arr;
	}
}
