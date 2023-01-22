package com.prep2020.hard;
import java.util.*;
public class Problem1232 {
	private Trie root;
	private int maxLength;
	private List<Character> chars;
	/**
	 * O(N * K) time and space
	 * where N is number of words and k is avg length of word
	 * @param words
	 */
	public Problem1232(String[] words) {
        root = new Trie();
        chars = new ArrayList<>();
        for (String w : words) {
        	String rev = new StringBuilder(w).reverse().toString();
        	maxLength = Math.max(maxLength, rev.length());
        	Trie cur = root;
        	for (char c : rev.toCharArray()) {
        		int idx = c - 'a';
        		if (cur.nexts[idx] == null) cur.nexts[idx] = new Trie();
        		cur = cur.nexts[idx];
        	}
        	cur.isWord = true;
        }
    }
    
	/**
	 * O(K) time where k is max number of letters in word
	 * @param letter
	 * @return
	 */
    public boolean query(char letter) {
        if (chars.size() == maxLength) chars.remove(chars.size() - 1);
        chars.add(0, letter);
        Trie cur = root;
        for (char c : chars) {
        	int idx = c - 'a';
        	if (cur.nexts[idx] == null) return false;
        	cur = cur.nexts[idx];
        	if (cur.isWord) return true;
        }
        return false;
    }
    
    class Trie {
    	Trie[] nexts = new Trie[26];
    	boolean isWord;
    }
}
