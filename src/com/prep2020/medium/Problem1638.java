package com.prep2020.medium;

public class Problem1638 {
	public int countSubstrings(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        int result = 0;
        for (int i = 0; i < n1; i++) {
        	for (int j = 0; j < n2; j++) {
        		int diff = 0;
        		for (int x = i, y = j; x < n1 && y < n2; x++, y++) {
        			if (s.charAt(x) != t.charAt(y)) {
        				if (diff > 0) break;
        				diff++;
        				result++;
        			} else if (diff == 1) result++;
        		}
        	}
        }
        return result;
    }
}
