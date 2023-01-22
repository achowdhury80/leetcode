package com.prep2020.medium;
import java.util.*;
public class Problem648 {
	public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for (String w : dictionary) {
        	Trie cur = root;
        	for (char c : w.toCharArray()) {
        		if (cur.arr[c - 'a'] == null) cur.arr[c - 'a'] = new Trie();
        		cur = cur.arr[c - 'a'];
        	}
        	cur.isRoot = true;
        }
        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
        	String r = null;
        	if ((r = findRoot(s, root)) != null) {
        		sb.append(r + " ");
        	} else sb.append(s + " ");
        }
        return sb.substring(0, sb.length() - 1);
    }
	private String findRoot(String s, Trie root) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (root.arr[c - 'a'] == null) return null;
			root = root.arr[c - 'a'];
			if (root.isRoot) return s.substring(0, i + 1);
		}
		return null;
	}
	class Trie {
		boolean isRoot;
		Trie[] arr = new Trie[26];
	}
}
