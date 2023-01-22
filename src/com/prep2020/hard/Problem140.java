package com.prep2020.hard;
import java.util.*;
public class Problem140 {
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		Trie root = new Trie();
		for (String w : wordDict) {
			Trie cur = root;
			for (char c : w.toCharArray()) {
				if (cur.arr[c - 'a'] == null) cur.arr[c - 'a'] = new Trie();
				cur = cur.arr[c - 'a'];
			}
			cur.isWord = true;
		}
		return helper(s.toCharArray(), 0, root, new HashMap<>());
		
    }
	
	
	private List<String> helper(char[] arr, int start, Trie root, Map<Integer, List<String>> cache) {
		if (cache.containsKey(start)) return cache.get(start);
		Trie cur = root;
		List<String> result = new ArrayList<>();
		for (int i = start; i < arr.length; i++) {
			if (cur.arr[arr[i] - 'a'] == null) break;
			cur = cur.arr[arr[i] - 'a'];
			if (cur.isWord) {
				if (i == arr.length - 1) {
					result.add(new String(arr, start, arr.length - start));
					break;
				} else {
					List<String> remaining = helper(arr, i + 1, root, cache);
					if (remaining.isEmpty()) continue;
					String before = new String(arr, start, i - start + 1);
					for (String s : remaining) result.add(before + " " + s);
				}
			}
		}
		cache.put(start, result);
		return result;
	}
	
	class Trie {
		Trie[] arr = new Trie[26];
		boolean isWord;
	}
}
