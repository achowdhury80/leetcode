package com.leet.algo;

public class Prob709 {
	public String toLowerCase(String str) {
		if (str == null) return str;
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
        	char c = arr[i];
        	if (Character.isLetter(c) && Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
        	else sb.append(c);
        }
        return sb.toString();
    }
}
