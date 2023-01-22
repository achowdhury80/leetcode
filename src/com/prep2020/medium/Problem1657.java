package com.prep2020.medium;
import java.util.*;
public class Problem1657 {
	public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int[] arr1 = new int[26], arr2 = new int[26];
        for (char c : word1.toCharArray()) arr1[c - 'a']++;
        for (char c : word2.toCharArray()) {
        	if (arr1[c - 'a'] == 0) return false;
        	arr2[c - 'a']++;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
        	if (arr1[i] == 0) continue;
        	countMap.put(arr1[i], countMap.getOrDefault(arr1[i], 0) + 1);
        }
        for (int i = 0; i < 26; i++) {
        	if (arr2[i] == 0) continue;
        	if (!countMap.containsKey(arr2[i])) return false;
        	countMap.put(arr2[i], countMap.get(arr2[i]) - 1);
        	if (countMap.get(arr2[i]) == 0) countMap.remove(arr2[i]);
        }
        return true;
    }
}
