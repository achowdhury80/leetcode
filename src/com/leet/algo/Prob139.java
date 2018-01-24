package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by ayanc on 1/22/18.
 */
public class Prob139 {
  private Trie root = new Trie();
  public boolean wordBreak(String s, List<String> wordDict) {
    if(wordDict == null || wordDict.size() < 1) return false;
    insert(wordDict);
    char[] chars = s.toCharArray();
    return wordBreak(chars, 0);
  }

  private boolean wordBreak(char[] chars, int start){
    Trie node = root;
    Stack<Integer> stack = new Stack<>();
    boolean failed = false;
    for(int i = start; i < chars.length; i++){
      if(node.children.containsKey(chars[i])) {
        node = node.children.get(chars[i]);
        if(node.endOfWord) {
          if(i < chars.length - 1){
            stack.push(i + 1);
          }
        }
      } else {
        if(node.endOfWord){
          stack.push(i);
        }
        failed = true;
        break;
      }
    }
    if(failed || !node.endOfWord) {
      while (!stack.isEmpty()){
        if(wordBreak(chars, stack.pop())) return true;
      }
      return false;
    }
    return true;
  }

  class Trie{
    Map<Character, Trie> children = new HashMap<>();
    boolean endOfWord;
  }

  private void insert(List<String> wordDict){
    for(String word : wordDict){
      char[] arr = word.toCharArray();
      Trie node = root;
      for(int i = 0; i < arr.length; i++){
        if(node.children.get(arr[i]) == null) node.children.put(arr[i], new Trie());
        node = node.children.get(arr[i]);
      }
      node.endOfWord = true;
    }
  }

  public static void main(String[] args){
    Prob139 prob139 = new Prob139();
    List<String> list = null;
    list = new ArrayList<>();
    list.add("leet");
    list.add("code");
    System.out.println(prob139.wordBreak("leetcode", list));
    list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("bbb");
    list.add("bbbb");
    System.out.println(prob139.wordBreak("bb", list));
    list = new ArrayList<>();
    list.add("a");
    list.add("abc");
    list.add("b");
    list.add("cd");
    System.out.println(prob139.wordBreak("abcd", list));
  }
}
