package com.prep2020.medium;

public class Problem676 {
	private Trie root;
	/** Initialize your data structure here. */
    public Problem676() {
        root = new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        for (String w : dictionary) {
        	Trie cur = root;
        	for (char c : w.toCharArray()) {
        		int idx = c - 'a';
        		if (cur.arr[idx] == null) cur.arr[idx] = new Trie();
        		cur = cur.arr[idx];
        	}
        	cur.isWord = true;
        }
    }
    
    private boolean searchExact(String w) {
    	Trie cur = root;
    	for (char c : w.toCharArray()) {
    		int idx = c - 'a';
    		if (cur.arr[idx] == null) return false;
    		cur = cur.arr[idx];
    	}
    	return cur.isWord;
    }
    
    public boolean search(String searchWord) {
        for (int i = 0; i < searchWord.length(); i++) {
        	char c = searchWord.charAt(i);
        	for (int j = 0; j < 26; j++) {
        		char ch = (char)('a' + j);
        		if (ch != c && searchExact(searchWord.substring(0, i) + ch 
        				+ searchWord.substring(i + 1))) return true;
        	}
        }
        return false;
    }
    
    class Trie {
    	Trie[] arr = new Trie[26];
    	boolean isWord;
    }
}
