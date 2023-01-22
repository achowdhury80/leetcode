package com.prep2020.hard;
import java.util.*;
public class Problem425 {
	public List<List<String>> wordSquares(String[] words) {
        Map<Integer, Trie> map = new HashMap<>();
        for (String w : words) {
        	Trie root = map.getOrDefault(w.length(), new Trie());
        	map.put(w.length(), root);
        	Trie cur = root;
        	for (char c : w.toCharArray()) {
        		if (cur.arr[c - 'a'] == null) cur = new Trie();
        		cur = cur.arr[c - 'a'];
        	}
        }
        List<List<String>> result = new ArrayList<>();
        for (String w : words) {
        	helper(w, map, result);
        }
        return result;
    }
	
	private void helper(String w, Map<Integer, Trie> map, List<List<String>> result) {
		if (w.length() == 1) {
			result.add(Arrays.asList(w));
			return;
		}
		Trie root = map.get(w.length());
		
		String prefix = "" + w.charAt(w.length() - 1);
		for (int i = 1; i < w.length() - 1; i++) {
			
			
		}
	}

	class Trie {
		Trie[] arr = new Trie[26];
		
	}
}
