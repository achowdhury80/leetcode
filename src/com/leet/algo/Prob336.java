package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 3/1/18.
 */
public class Prob336 {
  public List<List<Integer>> palindromePairs(String[] words) {
    int n;
    List<List<Integer>> result = new ArrayList<>();
    if (words == null || (n = words.length) < 2) return result;
    int[] emptyString = new int[1];
    emptyString[0] = -1;
    Trie root = build(words, emptyString);
    for (int j = 0; j < words.length; j++) findCompanion(words[j], root, j, result, emptyString);
    return result;
  }

  private Trie build(String[] words, int[] emptyString) {
    Trie root = new Trie();
    for (int j = 0; j < words.length; j++) {
      Trie node = root;
      if (words[j].equals("")) emptyString[0] = j;
      for (int i = 0; i < words[j].length(); i++) {
        if (!node.map.containsKey(words[j].charAt(i))) node.map.put(words[j].charAt(i), new Trie());
        node = node.map.get(words[j].charAt(i));
      }
      node.index = j;
    }
    return root;
  }

  private void findCompanion(String w, Trie root, int index, List<List<Integer>> result, int[] emptyString){
    String rev = new StringBuilder(w).reverse().toString();
    Trie node = root;
    for (int i = 0; i < rev.length(); i++) {
      char ch = rev.charAt(i);
      if (node.map.containsKey(ch)) {
        node = node.map.get(ch);
        if (node.index > -1 && node.index != index) {
          if (isPalindrome(rev.substring(i + 1))) result.add(Arrays.asList(node.index, index));
        }
      } else {
        node = null;
        break;
      }
    }
    if (node != null) dfs(node, index, result, "");
    if (emptyString[0] > -1 && index != emptyString[0] && isPalindrome(rev)) result.add(Arrays.asList(emptyString[0], index));

  }

  private void dfs(Trie node, int index, List<List<Integer>> result, String s) {
    if (node == null) return;
    for (Character c : node.map.keySet()) {
      Trie next = node.map.get(c);
      if (next.index > - 1 && isPalindrome(s + c)) {
        result.add(Arrays.asList(next.index, index));
      }
      dfs(next, index, result, s + c);
    }
  }

  private boolean isPalindrome(String s) {
    if (s.equals("")) return true;
    int i = 0, j = s.length() - 1;
    while (i < j){
      if (s.charAt(i) != s.charAt(j)) return false;
      i++;
      j--;
    }
    return true;
  }

  class Trie {
    Map<Character, Trie> map = new HashMap<>();
    int index = -1;
  }

  public static void main(String[] args) {
    Prob336 prob336 = new Prob336();
    System.out.println(prob336.palindromePairs(new String[]{"bat", "tab", "cat"}));
    System.out.println(prob336.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
    System.out.println(prob336.palindromePairs(new String[]{"a", ""}));
  }
}
