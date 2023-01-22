package com.prep2020.medium;
import java.util.*;
public class Problem792 {
	public int numMatchingSubseq(String s, String[] words) {
        TreeSet<Integer>[] arr = new TreeSet[26];
        for (int i = 0; i < s.length(); i++) {
        	int idx = s.charAt(i) - 'a';
        	if (arr[idx] == null) arr[idx] = new TreeSet<Integer>();
        	arr[idx].add(i);
        }
        int result = 0;
        for (String w : words) {
        	Integer last = -1;
        	boolean found = true;
        	for (char c : w.toCharArray()) {
        		int idx = c - 'a';
        		if (arr[idx] == null 
        				|| (last = arr[idx].higher(last)) == null) {
        			found = false;
        			break;
        		}
        	}
        	if (found) result++;
        }
        return result;
    }
}
