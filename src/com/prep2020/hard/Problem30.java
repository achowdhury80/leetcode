package com.prep2020.hard;
import java.util.*;
public class Problem30 {
	/**
	 * O(KN) where K is number of words and N is number of chars in S
	 * O(K) space
	 * @param s
	 * @param words
	 * @return
	 */
	public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> count = new HashMap<>();
        for (String w : words) count.put(w, count.getOrDefault(w, 0) + 1);
        int n = words[0].length();
        int m = words.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - m * n; i++) {
        	int j = 0;
        	Map<String, Integer> seen = new HashMap<>();
        	while(j < m) {
        		String sub = s.substring(i + j * n, i + (j + 1) * n);
        		if (!count.containsKey(sub)) break;
        		seen.put(sub, seen.getOrDefault(sub, 0) + 1);
        		if (seen.get(sub) > count.get(sub)) break;
        		j++;
        		if (j == m) {
        			result.add(i);
        		}
        	}
        }
        return result;
    }
}
