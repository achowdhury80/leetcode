package com.prep2020.medium;
import java.util.*;
public class Problem791 {
	/**
	 * O(N)
	 * @param S
	 * @param T
	 * @return
	 */
	public String customSortString(String S, String T) {
        boolean[] existsInS = new boolean[26];
        for (char c : S.toCharArray()) existsInS[c - 'a'] = true;
        Map<Character, String> existsInT = new HashMap<>();
        String result = "";
        for (char c : T.toCharArray()) {
        	if (!existsInS[c - 'a']) {
        		result += c;
        	}
        	else {
        		String s = existsInT.getOrDefault(c, "");
        		s += c;
        		existsInT.put(c, s);
        	}
        }
        for (char c : S.toCharArray()) if (existsInT.containsKey(c)) result += existsInT.get(c);
        return result;
    }
}
