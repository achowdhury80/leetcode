package com.leet.algo;

/**
 * Created by ayanc on 1/19/18.
 */
public class Prob208 {
  /** Initialize your data structure here. */
  private TrieNode root;
  public Prob208() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    if(word == null || word.length() < 1) return;
    char[] chars = word.toCharArray();
    TrieNode node = root;
    for(char c : chars){
      if(node.arr[c - 'a'] == null){
        node.arr[c - 'a'] = new TrieNode();
      }
      node = node.arr[c - 'a'];
    }
    node.isWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    if(word == null || word.length() < 1) return false;
    char[] chars = word.toCharArray();
    TrieNode node = root;
    for(char c : chars){
      if(node.arr[c - 'a'] == null) return false;
      node = node.arr[c - 'a'];
    }
    return node.isWord;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    if(prefix == null || prefix.equals("")) return true;
    char[] chars = prefix.toCharArray();
    TrieNode node = root;
    for(char c : chars){
      if(node.arr[c - 'a'] == null) return false;
      node = node.arr[c - 'a'];
    }
    return true;
  }

  class TrieNode {
    TrieNode[] arr = new TrieNode[26];
    boolean isWord;
  }

  public static void main(String[] args){
    Prob208 prob208 = new Prob208();
    //prob208.insert("Trie");
    //prob208.insert("startsWith");
    //System.out.println(prob208.search(""));
    System.out.println(prob208.startsWith("a"));
//    ["Trie","startsWith"]
//    [[],["a"]]
  }
}
