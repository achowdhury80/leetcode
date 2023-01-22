package com.prep2020.easy;

public class Problem2309 {
	public String greatestLetter(String s) {
        int[] arr = new int[26];
        String result = "";
        for (char c : s.toCharArray()) {
        	int idx = Character.toLowerCase(c) - 'a';
        	arr[idx] |= (Character.isUpperCase(c) ? 2 : 1);
        	if (arr[idx] == 3) {
        		if ("".equals(result) || ("" + Character.toUpperCase(c)).compareTo(result) > 0) 
        			result = "" + Character.toUpperCase(c);
        	}
        }
        return result;
    }
}
