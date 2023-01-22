package com.prep2020.hard;
import java.util.*;
public class Problem2272 {
	public int largestVariance(String s) {
		Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
        	set.add(c);
        }
        int result = 0;
        
        for (char c1 : set) {
        	for (char c2 : set) {
        		if (c1 == c2) continue;
        		int val = 0;
    			boolean hasC2 = false, firstC2 = false;
        		for (char c : s.toCharArray()) {
        			if (c != c1 && c != c2) continue;
        			if (c == c1) val++;
        			else {
        				hasC2 = true;
        				if (firstC2 && val >= 0) {
        					firstC2 = false;
        				} else {
        					val--;
        					if (val < 0) {
        						firstC2 = true;
        						val = -1;
        					}
        				}
        			}
        			result = Math.max(result, hasC2 ? val : 0);
        		}
        	}
        }
        return result;
    }
}
