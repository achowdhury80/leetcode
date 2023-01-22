package com.prep2020.medium;

import java.util.Arrays;

public class Problem1286 {
	private int len, max, cur = -1;
	private char[] arr;
	public Problem1286(String characters, int combinationLength) {
        arr = characters.toCharArray();
        Arrays.sort(arr);
        len = combinationLength;
        max = (int)Math.pow(2, arr.length) - 1;
        for (int i = max; i > -1; i--) {
        	if(Integer.bitCount(i) == len) {
        		cur = i;
        		break;
        	}
        }
    }
    
    public String next() {
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < arr.length; i++) {
        	if (((cur >> (arr.length - i - 1)) & 1) == 1) {
        		sb.append(arr[i]);
        	}
        }
        int temp = cur;
        cur = -1;
        for (int i = temp - 1; i > -1; i--) {
        	if(Integer.bitCount(i) == len) {
        		cur = i;
        		break;
        	} 
        }
        return sb.toString();
    }
    
    public boolean hasNext() {
        return cur != -1;
    }
}
