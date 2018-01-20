package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 1/19/18.
 */
public class Prob211 {
  private TrieNode root;
  /** Initialize your data structure here. */
  public Prob211() {
    root = new TrieNode();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    if(word == null || word.length() < 1) return;
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

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word){
    return search(word, root);
  }
  private boolean search(String word, TrieNode root) {
    if(word == null || word.length() < 1) return false;
    char[] chars = word.toCharArray();
    TrieNode node = root;
    for(int i = 0; i < chars.length; i++){
      char c = chars[i];
      if(c != '.'){
        if(node.arr[c - 'a'] == null) return false;
        node = node.arr[c - 'a'];
      } else {
        for(char ch = 'a'; ch <= 'z'; ch++){
          chars[i] = ch;
          String newWord = new String(Arrays.copyOfRange(chars, i, chars.length));
          if(search(newWord, node)) return true;
          chars[i] = '.';

        }
        return false;
      }
    }
    return node.endWord;
  }

  class TrieNode {
    TrieNode[] arr = new TrieNode[26];
    boolean endWord;
  }

  public static void main(String[] args){
    Prob211 prob211 = new Prob211();
    prob211.addWord("bad");
    prob211.addWord("dad");
    prob211.addWord("mad");
    System.out.println(prob211.search("pad"));
    System.out.println(prob211.search("bad"));
    System.out.println(prob211.search(".ad"));
    System.out.println(prob211.search("b.."));
  }
}
