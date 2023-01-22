package com.prep2020.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1371 {
	public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int mask = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	int idx = -1;
        	if ((idx = "aeiou".indexOf(c)) > -1) {
        		mask ^= (1 << idx);
        	}
        	if (map.containsKey(mask)) result = Math.max(result, i - map.get(mask));
        	else map.put(mask, i);
        }
        return result;
    }
}
