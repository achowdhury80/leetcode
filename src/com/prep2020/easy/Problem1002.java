package com.prep2020.easy;
import java.util.*;
public class Problem1002 {
	/**
	 * O(N)
	 * @param A
	 * @return
	 */
	public List<String> commonChars(String[] A) {
        int[] charMap = new int[26];
        for (char c : A[0].toCharArray()) charMap[c - 'a']++;
        for (int i = 1; i < A.length; i++) {
        	int[] counts = new int[26];
        	for (char c : A[i].toCharArray()) counts[c - 'a']++;
        	for (int j = 0; j < 26; j++) {
        		charMap[j] = Math.min(charMap[j], counts[j]);
        	}
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < charMap.length; i++) {
        	while(charMap[i] > 0) {
        		result.add("" + (char)(i + 'a'));
        		charMap[i]--;
        	}
        }
        return result;
    }
}
