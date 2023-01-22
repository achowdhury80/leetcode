package com.prep2020.medium;
import java.util.*;
public class Problem159 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	map.put(c, map.getOrDefault(c, 0) + 1);
        	while(map.size() > 2) {
        		c = s.charAt(start++);
        		map.put(c, map.get(c) - 1);
        		if (map.get(c) == 0) map.remove(c);
        	}
        	result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
