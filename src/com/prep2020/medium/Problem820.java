package com.prep2020.medium;

public class Problem820 {
	public int minimumLengthEncoding(String[] words) {
		Trie root = new Trie();
        for (String w : words) {
        	Trie cur = root;
        	for (char c : new StringBuilder(w).reverse().toString().toCharArray()) {
        		int idx = c - 'a';
        		if (cur.arr[idx] == null) cur.arr[idx] = new Trie();
        		cur = cur.arr[idx];
        	}
        	cur.isWord = true;
        }
        
        int result = 0;
        for (Trie t : root.arr) {
        	if (t != null) result += findHeight(t, 1);
        }
        return result;
    }
	
	private int findHeight(Trie cur, int height) {
		boolean found = false;
		int result = 0;
		for (Trie t : cur.arr) {
			if (t != null) {
				found = true;
				result += findHeight(t, height + 1);
			}
		}
		if (!found) return 1 + height;
		return result;
	}
	class Trie {
		Trie[] arr = new Trie[26];
		boolean isWord;
	}
}
