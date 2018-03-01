package com.leet.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ayanc on 2/26/18.
 */
public class Prob212 {
  public List<String> findWords(char[][] board, String[] words) {
    Trie root = buildTrie(words);
    Set<String> set = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, root, set);
      }
    }
    return new ArrayList<>(set);
  }

  private void dfs(char[][] board, int i, int j, Trie trie, Set<String> result) {
    char c;
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || (c = board[i][j]) == '#') return;
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

  private Trie buildTrie(String[] words) {
    Trie root = new Trie();
    for (String word : words) {
      Trie node = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (node.chars[c - 'a'] == null) {
          node.chars[c - 'a'] = new Trie();
        }
        node = node.chars[c - 'a'];
      }
      node.word = word;
    }
    return root;
  }

  class Trie {
    Trie[] chars = new Trie[26];
    String word;
  }

  public static void main(String[] args) {
    Prob212 prob212 = new Prob212();
    System.out.println(prob212.findWords(new char[][]{{'o','a','a','n'},
        {'e','t','a','e'},
        {'i','h','k','r'},
        {'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"}));
  }
}
