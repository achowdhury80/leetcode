package com.prep2020.hard;
import java.util.*;
public class Problem642 {
	private Trie root;
	private Map<Integer, Integer> freq;
	private List<String> strs;
	private Trie cur;
	private String curString = "";
	public Problem642(String[] sentences, int[] times) {
        root = new Trie();
        strs = new ArrayList<>();
        freq = new HashMap<>();
        cur = root;
        for (int i = 0; i < sentences.length; i++) {
        	for (char c : sentences[i].toCharArray()) {
        		int idx = -1;
        		if (c == ' ') idx = 26;
        		else idx = c - 'a';
        		if (cur.arr[idx] == null) {
        			cur.arr[idx] = new Trie();
        			cur.arr[idx].parent = cur;
        		}
        		cur = cur.arr[idx];
        	}
        	strs.add(sentences[i]);
        	freq.put(strs.size() - 1, times[i]);
        	cur.list.add(strs.size() - 1);
        	cur.list.sort((x, y) -> (freq.get(x) == freq.get(y) ? strs.get(x).compareTo(strs.get(y)) : freq.get(y) - freq.get(x)));
        	while (cur.list.size() > 3) cur.list.remove(cur.list.size() - 1);
        	updateParent(cur);
        }
        cur = root;
    }
    
    public List<String> input(char c) {
    	List<String> result = null;
    	if (c == '#') {
        	result = retrieveString(cur.list);
        	int index = strs.indexOf(curString);
        	if(index == -1) {
        		strs.add(curString);
        		index = strs.size() - 1;
        	}
        	int times = freq.getOrDefault(index, 0) + 1;
        	freq.put(index, times);
        	updateParent(cur);
        	cur = root;
        	curString = "";
        	return result;
        }
    	curString += c;
    	int idx = -1;
		if (c == ' ') idx = 26;
		else idx = c - 'a';
		if (cur.arr[idx] == null) {
			cur.arr[idx] = new Trie();
			cur.arr[idx].parent = cur;
		}
		return retrieveString(cur.list);
    }
    
    private List<String> retrieveString(List<Integer> index) {
    	List<String> result = new ArrayList<>();
		for (int i : index) result.add(strs.get(i));
		return result;
    }
    
    private void updateParent(Trie cur) {
    	if (cur.parent == null) return;
    	List<Integer> curList = cur.list;
    	cur = cur.parent;
    	for (int index : curList) {
    		if (cur.list.indexOf(index) < 0) {
	    		cur.list.add(index);
	    	}
    	}
    	cur.list.sort((x, y) -> (freq.get(x) == freq.get(y) ? strs.get(x).compareTo(strs.get(y)) : freq.get(y) - freq.get(x)));
    	while (cur.list.size() > 3) cur.list.remove(cur.list.size() - 1);
    	updateParent(cur);
    }
    
    class Trie {
    	Trie[] arr = new Trie[27];
    	List<Integer> list = new ArrayList<>();
    	Trie parent;
    }
    
    public static void main(String[] args) {
    	Problem642 problem = new Problem642(new String[] {"i love you","island","iroman","i love leetcode"}, new int[] {5,3,2,2});
    	System.out.println("123");
    }
}
