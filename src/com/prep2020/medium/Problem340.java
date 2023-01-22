package com.prep2020.medium;
import java.util.*;
public class Problem340 {
	/**
	 * O(N)
	 * @param s
	 * @param k
	 * @return
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	map.put(c, map.getOrDefault(c, 0) + 1);
        	while(map.size() > k) {
        		char rem = s.charAt(start++);
        		map.put(rem, map.get(rem) - 1);
        		if (map.get(rem) == 0) map.remove(rem);
        	}
        	result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
