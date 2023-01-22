package com.prep2020.hard;
import java.util.*;
public class Problem212 {
	public List<String> findWords(char[][] board, String[] words) {
        Trie root = buildTrie(words);
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		dfs(board, i, j, root, result);
        	}
        }
        return new ArrayList<>(result);
    }
	
	private void dfs(char[][] board, int i, int j, Trie cur, Set<String> result) {
		char c;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || (c = board[i][j]) == '#' || cur.arr[c - 'a'] == null) return;
		cur = cur.arr[c - 'a'];
		if (cur.word != null) result.add(cur.word);
		board[i][j] = '#';
		dfs(board, i + 1, j, cur, result);
		dfs(board, i - 1, j, cur, result);
		dfs(board, i, j + 1, cur, result);
		dfs(board, i, j - 1, cur, result);
		board[i][j] = c;
		
	}

	class Trie {
		Trie[] arr = new Trie[26];
		String word;
	}
	
	public Trie buildTrie(String[] words) {
		Trie root = new Trie();
		for (String w : words) {
			Trie cur = root;
			for (char c : w.toCharArray()) {
				if (cur.arr[c - 'a'] == null) cur.arr[c - 'a'] = new Trie();
				cur = cur.arr[c - 'a'];
			}
			cur.word = w;
		}
		return root;
	}
}
