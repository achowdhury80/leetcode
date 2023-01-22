package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2067 {
	public int equalCountSubstrings(String s, int count) {
		int result = 0;
        for (int i = 1; i <= Math.min(s.length(), 26); i++)
        	result += helper(s, i, count);
        return result;
    }
	
	private int helper(String s, int numChars, int count) {
		int windowSize = numChars * count, n = s.length(), start = 0, 
				result = 0;
		if (n < windowSize) return 0;
		Map<Character, Integer> map = new HashMap<>();
		int countReached = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.get(c) == count) countReached++;
			
			if (i - start + 1 > windowSize) {
				c = s.charAt(start);
				if (map.get(c) == count) countReached--;
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0) map.remove(c);
				start++;
			}
			
			if (i - start + 1 == windowSize && countReached == numChars 
					&& map.size() == numChars) result++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem2067 problem = new Problem2067();
		System.out.println(problem.equalCountSubstrings("aaabcbbcc", 3));
	}
}
