package com.prep2020.medium;
import java.util.*;
public class Problem1297 {
	/**
	 * O(N)
	 * maxSize is not needed. 
	 * @param s
	 * @param maxLetters
	 * @param minSize
	 * @param maxSize
	 * @return
	 */
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int start = 0, result = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        Map<String, Integer> subStrMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	charMap.put(c,charMap.getOrDefault(c,0)+1);
        	if (i - start + 1 > minSize) {
        		char sChar = s.charAt(start);
        		charMap.put(sChar,charMap.get(sChar)-1);
                if(charMap.get(sChar)==0) charMap.remove(sChar);
                start++;
        	}
        	if (i - start + 1 == minSize && charMap.size() <= maxLetters) {
        		String sub = s.substring(start, i + 1);
        		subStrMap.put(sub, subStrMap.getOrDefault(sub, 0) + 1);
        		result = Math.max(result, subStrMap.get(sub));
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1297 problem = new Problem1297();
		//System.out.println(problem.maxFreq("aababcaab",2,3,4));
		System.out.println(problem.maxFreq("aabcabcab",2,2, 3));
	}
}
