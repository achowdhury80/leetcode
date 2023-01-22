package com.prep2020.medium;
import java.util.*;
public class Problem1324 {
	public List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        int maxLen = Integer.MIN_VALUE;
        for (String st : arr) maxLen = Math.max(maxLen, st.length());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < maxLen; i++) result.add("");
        for (int i = 0; i < maxLen; i++) {
        	for (int j = 0; j < arr.length; j++) {
        		if (i < arr[j].length())  result.set(i, addSpacesAndChar(new StringBuilder(result.get(i)), j + 1, arr[j].charAt(i)));
        	}
        }
        return result;
    }
	
	private String addSpacesAndChar(StringBuilder sb, int len, char c) {
		while(sb.length() < len - 1) sb.append(" ");
		sb.append(c);
		return sb.toString();
	}
}
