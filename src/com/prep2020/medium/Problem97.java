package com.prep2020.medium;
import java.util.*;
public class Problem97 {
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return helper(s1, s2, s3, 0, 0, 0, new HashMap<>());
    }
	
	private boolean helper(String s1, String s2, String s3, int start1, 
			int start2, int start3, Map<Integer, Boolean> cache) {
		if (start3 == s3.length()) return true;
		int key = (start1 << 7) | start2;
		if (cache.containsKey(key)) return cache.get(key);
		if (start1 == s1.length()) {
			cache.put(key, s2.substring(start2).equals(s3.substring(start3)));
		} else if (start2 == s2.length()) {
			cache.put(key, s1.substring(start1).equals(s3.substring(start3)));
		} else {
			char c1 = s1.charAt(start1), c2 = s2.charAt(start2), c3 = s3.charAt(start3);
			if (c3 == c1 && c3 == c2) {
				cache.put(key, helper(s1, s2, s3, start1 + 1, start2, start3 + 1, cache)
						|| helper(s1, s2, s3, start1, start2 + 1, start3 + 1, cache));
			} else if (c3 == c1) {
				cache.put(key, helper(s1, s2, s3, start1 + 1, start2, start3 + 1, cache));
			} else if (c3 == c2) {
				cache.put(key, helper(s1, s2, s3, start1, start2 + 1, start3 + 1, cache));
			} else {
				cache.put(key, false);
			}
		} 
		return cache.get(key);
	}
}
