package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 12/8/17.
 */
public class Prob648 {
  private TrieNode root = new TrieNode();
  public String replaceWords(List<String> dict, String sentence) {
    buildDict(dict);
    String[] arr = sentence.split(" ");
    String result = "";
    for(String st : arr){
      String wordRoot = findRoot(st, root);
      result += (wordRoot == null ? st : wordRoot) + " ";
    }
    return result.substring(0, result.length() - 1);
  }


  private void buildDict(List<String> dict) {
    if(dict == null || dict.size() == 0) return;
    for(int i = 0; i < dict.size(); i++){
      String word = dict.get(i);
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

  private String findRoot(String word, TrieNode root){
    TrieNode node = root;
    char[] chars = word.toCharArray();
    for(int i = 0; i < word.length(); i++){
      char c = word.charAt(i);
      if(node.arr[c - 'a'] == null) return null;
      node = node.arr[c - 'a'];
      if(node.endWord) return word.substring(0, i + 1);
    }
    return null;
  }

  class TrieNode {
    TrieNode[] arr = new TrieNode[26];
    boolean endWord;
  }

  public static void main(String[] args){
    Prob648 prob648 = new Prob648();

    List<String> dict = new ArrayList();
    dict.add("cat");
    dict.add("bat");
    dict.add("rat");
    System.out.println(prob648.replaceWords(dict, "the cattle was rattled by the battery"));
  }
}
