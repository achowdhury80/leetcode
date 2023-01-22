package com.prep2020.hard;
import java.util.*;

public class Problem10 {
	/**
	 * O(TP) time and space where T is length of S and P is length of P
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0, new HashMap<>());
    }
	
	private boolean helper(String s, String p, int sStart, int pStart, Map<Integer, Boolean> cache) {
		int key = (sStart << 5) | pStart;
		if (cache.containsKey(key)) return cache.get(key);
		if (pStart == p.length()) {
			if (sStart == s.length()) {
				cache.put(key, true);
				return true;
			}
			cache.put(key, false);
			return false;
		}
		if (sStart == s.length()) {
			if (!(pStart + 1 < p.length()) || p.charAt(pStart + 1) != '*') {
				cache.put(key, false);
				return false;
			}
			cache.put(key, helper(s, p, sStart, pStart + 2, cache));
			return cache.get(key);
		}
		char c = p.charAt(pStart);
		if (pStart + 1 < p.length() && p.charAt(pStart + 1) == '*') {
			cache.put(key, helper(s, p, sStart, pStart + 2, cache) 
					|| ((c == '.' || c == s.charAt(sStart)) && helper(s, p, sStart + 1, pStart, cache)));
			return cache.get(key);
		}
		if (c == '.' || s.charAt(sStart) == c) {
			cache.put(key, helper(s, p, sStart + 1, pStart + 1, cache));
			return cache.get(key);
		}
		cache.put(key, false);
		return false;
	}
	
	public static void main(String[] args) {
		Problem10 prob = new Problem10();
		System.out.println(prob.isMatch("mississippi", "mis*is*ip*."));
	}
}
