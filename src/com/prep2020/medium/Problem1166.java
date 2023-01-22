package com.prep2020.medium;
import java.util.*;
public class Problem1166 {
	private Trie root;
	public Problem1166() {
        root = new Trie();
    }
    
    public boolean createPath(String path, int value) {
    	String[] arr = path.substring(1).split("/");
        Trie cur = root;
        for (int i = 0; i < arr.length - 1; i++) {
        	if (!cur.map.containsKey(arr[i])) return false;
        	cur = cur.map.get(arr[i]);
        }
        if (cur.map.containsKey(arr[arr.length - 1])) return false;
        Trie trie = new Trie();
        trie.value = value;
        cur.map.put(arr[arr.length - 1], trie);
        return true;
    }
    
    public int get(String path) {
    	String[] arr = path.substring(1).split("/");
        Trie cur = root;
        for (int i = 0; i < arr.length; i++) {
        	if (!cur.map.containsKey(arr[i])) return -1;
        	cur = cur.map.get(arr[i]);
        }
        return cur.value;
    }
    
    class Trie {
    	Map<String, Trie> map = new HashMap<>();
    	int value;
    }
}
