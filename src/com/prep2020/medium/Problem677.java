package com.prep2020.medium;
import java.util.*;
public class Problem677 {
	/** Initialize your data structure here. */
	private Trie root;
    public Problem677() {
        root = new Trie();
    }
    
    public void insert(String key, int val) {
        Trie cur = root;
        for (char c : key.toCharArray()) {
        	int idx = c - 'a';
        	if (cur.arr[idx] == null) cur.arr[idx] = new Trie();
        	cur = cur.arr[idx];
        }
        cur.val = val;
    }
    
    public int sum(String prefix) {
    	Trie cur = root;
        for (char c : prefix.toCharArray()) {
        	int idx = c - 'a';
        	if (cur.arr[idx] == null) return 0;
        	cur = cur.arr[idx];
        }
        int result = 0;
        Deque<Trie> stack = new ArrayDeque<>();
        stack.push(cur);
        while(!stack.isEmpty()) {
        	cur = stack.pop();
        	result += cur.val;
        	for (Trie trie : cur.arr) {
        		if (trie != null) stack.push(trie);
        	}
        }
        return result;
    }
    
    class Trie {
    	Trie[] arr = new Trie[26];
    	int val;
    }
}
