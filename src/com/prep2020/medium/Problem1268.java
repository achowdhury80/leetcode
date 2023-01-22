package com.prep2020.medium;
import java.util.*;
public class Problem1268 {
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Trie root = new Trie();
        for (String p : products) addWord(root, p);
        List<List<String>> result = new ArrayList<>(); 
        Trie cur = root;
        for (char c : searchWord.toCharArray()) {
        	if(cur != null) cur = findTrie(cur, c);
        	List<String> words = new ArrayList<>();
        	if (cur == null) result.add(words);
        	else {
        		findWords(cur, words);
        		result.add(words);
        	}
        }
        return result;
    }
	
	private void findWords(Trie cur, List<String> words) {
		if (cur.word != null) words.add(cur.word);
		if (words.size() == 3) return;
		for (int i = 0; i < 26; i++) {
			if (words.size() == 3) return;
			if (cur.arr[i] != null) {
				findWords(cur.arr[i], words);
			}
		}
	}

	private Trie findTrie(Trie cur, char c) {
		return cur.arr[c - 'a'];
	}

	private void addWord(Trie trie, String w) {
		for (char c : w.toCharArray()) {
			if (trie.arr[c - 'a'] == null) trie.arr[c - 'a'] = new Trie();
			trie = trie.arr[c - 'a'];
		}
		trie.word = w;
	}
	
	class Trie {
		Trie[] arr = new Trie[26];
		String word;
	}
}
