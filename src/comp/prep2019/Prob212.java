package comp.prep2019;
import java.util.*;

public class Prob212 {
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
	
	
	private void dfs(char[][] board, int i, int j, Trie trie, Set<String> result) {
		char c;
	    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
	    		|| (c = board[i][j]) == '#') return;
	    if (trie.chars[c - 'a'] != null) {
	    	trie = trie.chars[c - 'a'];
	    	if (trie.word != null) result.add(trie.word);
	    	board[i][j] = '#';
	    	dfs(board, i + 1, j, trie, result);
	        dfs(board, i - 1, j, trie, result);
	        dfs(board, i, j + 1, trie, result);
	        dfs(board, i, j - 1, trie, result);
	        board[i][j] = c;
	    }
	}


	class Trie {
		Trie[] chars = new Trie[26];
		String word;
	}
	
	private Trie buildTrie(String[] words) {
		Trie root = new Trie();
		for (String w : words) {
			Trie cur = root;
			for (char c : w.toCharArray()) {
				if (cur.chars[c - 'a'] == null) cur.chars[c - 'a'] = new Trie();
				cur = cur.chars[c - 'a'];
			}
			cur.word = w;
		}
		return root;
	}
}
