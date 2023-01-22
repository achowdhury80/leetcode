package com.prep2020.hard;

import java.util.*;

public class Problem471 {
	public String encode(String s) {
        return helper(s, new HashMap<>());
    }
	
	private String helper(String s, Map<String, String> cache) {
		if (cache.containsKey(s)) return cache.get(s);
		int n = s.length();
		if (n < 5) return s;
		String result = s;
		for (int i = 1; i < n; i++) {
			String temp = helper(s.substring(0, i), cache) + helper(s.substring(i), cache);
			if (temp.length() < result.length()) result = temp;
		}
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0 && s.replaceAll(s.substring(0, i), "").equals("")) {
				String temp = (n / i) + "[" + helper(s.substring(0, i), cache) + "]"; 
				if (temp.length() < result.length()) result = temp;
			}
		}
		cache.put(s, result);
		return result;
	}
}
