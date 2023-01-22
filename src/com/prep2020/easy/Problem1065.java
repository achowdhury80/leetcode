package com.prep2020.easy;
import java.util.*;
public class Problem1065 {
	/**
	 * ??
	 * @param text
	 * @param words
	 * @return
	 */
	public int[][] indexPairs(String text, String[] words) {
		Trie root = new Trie();
		
		for (String w : words) {
			Trie cur = root;
			for (char c : w.toCharArray()) {
				if (cur.arr[c - 'a'] == null) cur.arr[c - 'a'] = new Trie();
				cur = cur.arr[c - 'a'];
			}
			cur.isWord = true;
		}
		List<int[]> list = new ArrayList<>();
		
		for (int i = 0; i < text.length(); i++) {
			List<int[]> indices = findIndices(root, text, i);
			list.addAll(indices);
		}
		
		list.sort((x, y) -> x[0] == y[0] ? (x[1] - y[1]) : (x[0] - y[0]));
		int[][] result = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
		return result;
    }
	
	private List<int[]> findIndices(Trie root, String text, int startIndex) {
		List<int[]> result = new ArrayList<>();
		Trie cur = root;
		for(int i = startIndex; i < text.length(); i++) {
			char c = text.charAt(i);
			if (cur.arr[c - 'a'] == null) break;
			cur = cur.arr[c - 'a'];
			if (cur.isWord) result.add(new int[] {startIndex, i});
		}
		return result;
	}

	class Trie {
		Trie[] arr = new Trie[26];
		boolean isWord;
	}
}
