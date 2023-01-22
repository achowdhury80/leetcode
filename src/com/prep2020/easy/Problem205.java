package com.prep2020.easy;
import java.util.*;
public class Problem205 {
	/*
	 * O(N) time and space
	 */
	public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) return true;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
        	char c1 = s.charAt(i), c2 = t.charAt(i);
        	if (map.containsKey(c1)) {
        		if (c2 != map.get(c1)) return false;
        	} else {
        		if (map.values().contains(c2)) return false;
        		map.put(c1, c2);
        	}
        }
        return true;
    }
}
