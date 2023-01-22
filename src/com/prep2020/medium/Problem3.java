package com.prep2020.medium;
import java.util.*;
public class Problem3 {
	/**
	 * O(N) time and space
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
        int start = 0, result = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	while(set.contains(c)) set.remove(s.charAt(start++));
        	set.add(c);
        	result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
