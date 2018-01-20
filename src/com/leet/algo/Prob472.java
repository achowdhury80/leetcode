package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/19/18.
 */
public class Prob472 {
  private TrieNode root = new TrieNode();
  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    for(String word : words) addWord(word);
    List<String> list = new ArrayList<>();
    for (String word : words){
      if(isConcatenated(word)) list.add(word);
    }
    return list;
  }

  private void addWord(String word) {
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

  private boolean isConcatenated(String word){
    if(word == null || word.length() < 1) return false;
    char[] chars = word.toCharArray();
    TrieNode node = root;
    int endWordCount = 0;
    for(char c : chars){
      node = node.arr[c - 'a'];
      if (node.endWord) {
        endWordCount++;
        if(endWordCount > 1) return true;
      }
    }
    return false;
  }

  class TrieNode {
    TrieNode[] arr = new TrieNode[26];
    boolean endWord;
  }

  public static void main(String[] args){
    Prob472 prob472 = new Prob472();
    System.out.println(prob472.findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
  }
}
