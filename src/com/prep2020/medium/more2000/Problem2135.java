package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2135 {
	public int wordCount(String[] startWords, String[] targetWords) {
		Trie root = new Trie();
		for (String s : startWords) {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			addToTrie(root, arr);
		}
		int result = 0;
        for (String s : targetWords) {
        	char[] arr = s.toCharArray();
        	Arrays.sort(arr);
        	s = new String(arr);
        	for (int i = 0; i < s.length(); i++) 
        		if (foundInTrie(root, s.substring(0, i) + s.substring(i + 1))) {
        			result++;
        			break;
        		}
        }
        return result;
    }
	
	
	
	private boolean foundInTrie(Trie root, String s) {
		Trie cur = root;
		for (char c : s.toCharArray()) {
			if (cur.arr[c - 'a'] == null) return false;
			cur = cur.arr[c - 'a'];
		}
		return cur.isWord;
	}



	private void addToTrie(Trie root, char[] arr) {
		Trie cur = root;
		for (char c : arr) {
			if (cur.arr[c - 'a'] == null) cur.arr[c - 'a'] = new Trie();
			cur = cur.arr[c - 'a'];
		}
		cur.isWord = true;
	}



	class Trie {
		Trie[] arr = new Trie[26];
		boolean isWord;
	}
	
	public static void main(String[] args) {
		Problem2135 problem = new Problem2135();
		System.out.println(problem.wordCount(
				new String[] {"g","vf","ylpuk","nyf","gdj","j","fyqzg","sizec"}, 
				new String[] {"r","am","jg","umhjo","fov","lujy","b","uz","y"}));
	}
}
