package com.prep2020.easy;
import java.util.*;
public class Problem2273 {
	public List<String> removeAnagrams(String[] words) {
        Deque<String> stack = new ArrayDeque<>();
        Map<String, int[]> cache = new HashMap<>();
        for (String w : words) {
        	if (stack.isEmpty() || !isAnagram(stack.peek(), w, cache)) stack.push(w);
        }
        List<String> result = new ArrayList<>();
        while(!stack.isEmpty()) result.add(0, stack.pop());
        return result;
    }

	private boolean isAnagram(String peek, String w, Map<String, int[]> cache) {
		int[] arr1 = new int[26], arr2 = new int[26];
		if (cache.containsKey(w)) arr1 = cache.get(w);
		else {
			for (char c : w.toCharArray()) arr1[c - 'a']++;
			cache.put(w, arr1);
		}
		if (cache.containsKey(peek)) arr2 = cache.get(peek);
		else {
			for (char c : peek.toCharArray()) arr2[c - 'a']++;
			cache.put(peek, arr2);
		}
		for (int i = 0; i < 26; i++) if (arr1[i] != arr2[i]) return false;
		return true;
	}
}
