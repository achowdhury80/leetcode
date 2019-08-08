package com.leet.algo;
import java.util.*;
public class Prob1044 {
	public String longestDupSubstring(String S) {
        int min = 1, max = S.length() - 1;
        String result = "";
        while(min < max) {
        	int mid = min + (max - min) / 2;
        	Set<String> set = new HashSet<>();
        	boolean found = false;
        	for (int i = 0; i + mid - 1 < S.length(); i++) {
        		String sub = S.substring(i, i + mid);
        		if (set.contains(sub)) {
        			min = mid + 1;
        			result = sub;
        			found = true;
        			break;
        		} else set.add(sub);
        	}
        	if (!found) max = mid - 1;
        }
        return result;
    }
}
