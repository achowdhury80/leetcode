package com.prep2020.medium;
public class Problem1804 {
	private Trie root;
	public Problem1804() {
        root = new Trie();
    }
    
    public void insert(String word) {
        Trie cur = root;
        for (char c : word.toCharArray()) {
        	int idx = c - 'a';
        	if (cur.arr[idx] == null) cur.arr[idx] = new Trie();
        	cur = cur.arr[idx];
        }
        cur.count++;
    }
    
    public int countWordsEqualTo(String word) {
    	Trie cur = root;
        for (char c : word.toCharArray()) {
        	int idx = c - 'a';
        	if (cur.arr[idx] == null) return 0;
        	cur = cur.arr[idx];
        }
        return cur.count;
    }
    
    public int countWordsStartingWith(String prefix) {
    	Trie cur = root;
        for (char c : prefix.toCharArray()) {
        	int idx = c - 'a';
        	if (cur.arr[idx] == null) return 0;
        	cur = cur.arr[idx];
        }
        return findNumberofWordsStartingWith(cur);
    }
    
    public void erase(String word) {
    	Trie cur = root;
    	for (char c : word.toCharArray()) {
        	int idx = c - 'a';
        	cur = cur.arr[idx];
        }
        cur.count--;
    }
    
    private int findNumberofWordsStartingWith(Trie cur) {
    	int result = cur.count;
    	for (int i = 0; i < 26; i++) {
    		if (cur.arr[i] != null) result += findNumberofWordsStartingWith(cur.arr[i]);
    	}
    	return result;
    }
    
    class Trie {
    	Trie[] arr = new Trie[26];
    	int count;
    }
    
    public static void main(String[] args) {
    	Problem1804 problem = new Problem1804();
    	problem.insert("apple");
    	problem.insert("apple");
    }
}
