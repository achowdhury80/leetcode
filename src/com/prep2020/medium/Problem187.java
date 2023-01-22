package com.prep2020.medium;

import java.util.*;

public class Problem187 {
	/**
	 * O(N) time and space
	 * Rabin - Karp
	 * @param s
	 * @return
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> output = new HashSet<>();
		if (s.length() < 11) return new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('A', 0);
        charMap.put('C', 1);
        charMap.put('G', 2);
        charMap.put('T', 3);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = charMap.get(s.charAt(i));
        int cur = 0;
        for (int i = 0; i < s.length() - 9; i++) {
        	if (i == 0) {
        		for (int j = 0; j < 10; j++) {
        			cur = (cur << 2) | arr[j];
        		}
        	} else {
        		cur = (cur << 2) | arr[i + 9];
        		cur &= ~(3 << 20);
        	}
        	if (seen.contains(cur)) output.add(s.substring(i, i + 10));
        	seen.add(cur);
        }
        return new ArrayList<>(output);
    }
}
