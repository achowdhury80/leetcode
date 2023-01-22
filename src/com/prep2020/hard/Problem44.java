package com.prep2020.hard;
import java.util.*;
public class Problem44 {
	public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0, new HashMap<>());
    }
	
	private boolean helper(String s, String p, int sStart, int pStart, Map<Integer, Boolean> cache) {
		int key = (sStart << 11) | pStart;
		if (cache.containsKey(key)) return cache.get(key);
		if (pStart == p.length()) {
			cache.put(key, sStart == s.length());
			return cache.get(key);
		}
		if (sStart == s.length() && p.charAt(pStart) != '*') {
			cache.put(key, false);
			return cache.get(key);
		}
		// * = no char 
		if (p.charAt(pStart) == '*' && helper(s, p, sStart, pStart + 1, cache)) {
			cache.put(key, true);
			return cache.get(key);
		}
		if (sStart == s.length()) {
			cache.put(key, false);
			return cache.get(key);
		}
		if (p.charAt(pStart) == '*') cache.put(key, helper(s, p, sStart + 1, pStart, cache));
		else if (p.charAt(pStart) == '?' || p.charAt(pStart) == s.charAt(sStart)) 
			cache.put(key, helper(s, p, sStart + 1, pStart + 1, cache));
		else cache.put(key, false);
		return cache.get(key);
		
	}
	
	public static void main(String[] arga) {
		Problem44 problem = new Problem44();
		System.out.println(problem.isMatch("cb", "?a"));
	}
}
