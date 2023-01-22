package com.prep2020.medium;

public class Problem1698 {
	/**
	 * if a new node is added then new substring
	 * @param s
	 * @return
	 */
	public int countDistinct(String s) {
		Trie root = new Trie();
		int result = 0;
        for (int i = 0; i < s.length(); i++) {
        	Trie cur = root;
        	for (int j = i; j < s.length(); j++) {
        		int idx = s.charAt(j) - 'a';
        		if (cur.arr[idx] == null) {
        			result++;
        			cur.arr[idx] = new Trie();
        		}
        		cur = cur.arr[idx];
        	}
        }
        return result;
    }
	
	class Trie {
		Trie[] arr = new Trie[26];
	}
}
