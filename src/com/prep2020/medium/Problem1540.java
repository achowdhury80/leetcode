package com.prep2020.medium;
import java.util.*;
public class Problem1540 {
	public boolean canConvertString(String s, String t, int k) {
		if (s.length() != t.length()) return false;
        int n = s.length();
        Map<Integer, Integer> convertMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	char c1 = s.charAt(i), c2 = t.charAt(i);
        	int diff = ((c2 - 'a') + 26 - (c1 - 'a')) % 26;
        	if (diff != 0) convertMap.put(diff, convertMap.getOrDefault(diff, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> e : convertMap.entrySet()) {
        	if (((e.getValue() - 1) * 26) + e.getKey() > k) return false;
        }
        return true;
    }
}
