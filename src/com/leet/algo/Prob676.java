package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 12/8/17.
 */
public class Prob676 {
  private TrieNode root;

  public Prob676(){
    root = new TrieNode();
  }
  /** Build a dictionary through a list of words */
  public void buildDict(String[] dict) {
    if(dict == null || dict.length == 0) return;
    for(int i = 0; i < dict.length; i++){
      String word = dict[i];
      if(word.length() < 1) continue;;
      char[] chars = word.toCharArray();
      TrieNode node = root;
      for(char c : chars){
        if(node.arr[c - 'a'] == null){
          node.arr[c - 'a'] = new TrieNode();
        }
        node = node.arr[c - 'a'];
      }
      node.endWord = true;
    }
  }

  /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
  public boolean search(String word) {
    if(word == null || word.length() < 1) return false;
    char[] chars = word.toCharArray();
    for(int i = 0; i < chars.length; i++){
      for(char c = 'a'; c <= 'z'; c++){
        if(chars[i] == c) continue;
        char orig = chars[i];
        chars[i] = c;
        if(find(chars, root)) return true;
        chars[i] = orig;
      }
    }
    return false;
  }

  private boolean find(char[] chars, TrieNode root){
    TrieNode node = root;
    for(char c : chars){
      if(node.arr[c - 'a'] == null) return false;
      node = node.arr[c - 'a'];
    }
    return node.endWord;
  }

  class TrieNode {
    TrieNode[] arr = new TrieNode[26];
    boolean endWord;
  }
}
