package com.prep2020.hard;
import java.util.*;
public class Problem76 {
	/**
	 * O(N) time and O(1) space
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int count = t.length();
        int start = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (map.containsKey(c)) {
        		map.put(c, map.get(c) - 1);
        		if (map.get(c) > -1) count--;
        	}
        	while(count == 0) {
        		if("".equals(result) || (result.length() > i - start + 1)) {
        			result = s.substring(start, i + 1);
        		}
        		if (map.containsKey(s.charAt(start))) {
        			c = s.charAt(start);
        			map.put(c, map.get(c) + 1);
        			if (map.get(c) > 0) count++;
        		}
        		start++;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem76 problem = new Problem76();
		System.out.println(problem.minWindow("ADOBECODEBANC", "ABC"));
	}
}
