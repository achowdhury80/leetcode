package com.prep2020.medium;

public class Problem211 {
	private Trie root;
	/** Initialize your data structure here. */
    public Problem211() {
        root = new Trie();
    }
    
    public void addWord(String word) {
    	Trie cur = root;
        for (char c : word.toCharArray()) {
        	if (cur.arr[c - 'a'] == null) cur.arr[c - 'a'] = new Trie();
        	cur = cur.arr[c - 'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return search(word, root);
    }
    
    private boolean search(String word, Trie cur) {
    	if (word.length() == 0) return cur.isWord;
    	for (int i = 0; i < word.length(); i++) {
    		char c = word.charAt(i);
    		if (c == '.') {
    			for (Trie trie : cur.arr) if (trie != null && search(word.substring(i + 1), trie)) return true;
    			return false;
    		} else {
    			if (cur.arr[c - 'a'] == null) return false;
    			cur = cur.arr[c - 'a'];
    		}
    	}
    	return cur.isWord;
    }
    
    class Trie {
    	Trie[] arr = new Trie[26];
    	boolean isWord;
    }
}
