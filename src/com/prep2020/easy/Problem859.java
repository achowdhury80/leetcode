package com.prep2020.easy;
import java.util.*;
public class Problem859 {
	public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        List<Integer> unMatchedIndex = new ArrayList<>();
        int[] arr = new int[26];
        boolean duplicate = false;
        for (int i = 0; i < A.length(); i++) {
        	if (A.charAt(i) != B.charAt(i)) {
        		unMatchedIndex.add(i);
        		if (unMatchedIndex.size() > 2) return false;
        	}
        	if (arr[A.charAt(i) - 'a'] > 0) {
    			duplicate = true;
    		} else arr[A.charAt(i) - 'a']++;
        }
        if (unMatchedIndex.isEmpty()) {
        	return duplicate;
        } else if (unMatchedIndex.size() == 2) {
        	return A.charAt(unMatchedIndex.get(0)) == B.charAt(unMatchedIndex.get(1)) 
        			&& A.charAt(unMatchedIndex.get(1)) == B.charAt(unMatchedIndex.get(0));
        }
        return false;
    }
}
