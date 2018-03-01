package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob677 {
  private Trie root;
  public Prob677() {
    root = new Trie();
  }

  public void insert(String key, int val) {
    Trie node = root;
    for (int i = 0; i < key.length(); i++) {
      if (!node.map.containsKey(key.charAt(i))) {
        node.map.put(key.charAt(i), new Trie());
      }
      node = node.map.get(key.charAt(i));
    }
    node.val = val;
    node.word = true;
  }

  public int sum(String prefix) {
    Trie node = root;
    for (int i = 0; i < prefix.length(); i++) {
      if (!node.map.containsKey(prefix.charAt(i))) return 0;
      node = node.map.get(prefix.charAt(i));
    }
    return dfs(node);
  }

  private int dfs(Trie trie) {
    int sum = 0;
    if (trie.word) sum += trie.val;
    for (Trie trie1 : trie.map.values()) {
      sum += dfs(trie1);
    }
    return sum;
  }
  class Trie {
    Map<Character, Trie> map = new HashMap<>();
    int val;
    boolean word;
  }
}
