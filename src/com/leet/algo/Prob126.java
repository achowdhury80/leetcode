package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ayanc on 2/22/18.
 */
public class Prob126 {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    if (wordList == null || wordList.isEmpty()) return result;

    Queue<String> q = new LinkedList<>();
    q.add(beginWord);
    Map<String, Set<String>> map = new HashMap<>();
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    Set<String> dict = new HashSet<>(wordList);
    dict.remove(beginWord);
    if (!dict.contains(endWord)) return result;
    boolean found = false;
    while (!q.isEmpty() && !found) {
      Set<String> tempVisited = new HashSet<>();
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String w = q.poll();
        char[] chars = w.toCharArray();
        for (int j = 0; j < chars.length; j++) {
          char ch = chars[j];
          for (char c = 'a'; c <= 'z'; c++) {
            if (ch == c) continue;
            chars[j] = c;
            String s = new String(chars);
            if (dict.contains(s) && !visited.contains(s)) {
              if (!visited.contains(s)) {
                q.add(s);
                tempVisited.add(s);
              }
              if (!map.containsKey(s)) map.put(s, new HashSet<>());
              map.get(s).add(w);
              if (s.equals(endWord)) {
                found = true;
              }
            }
          }
          chars[j] = ch;
        }
      }
      visited.addAll(tempVisited);
      //unvisited.removeAll(visited);
      //visited.addAll(tempVisited);
    }
    helper(map, beginWord, endWord, result, new ArrayList<>());
    return result;
  }

  private void helper(Map<String, Set<String>> map, String beginWord, String endWord, List<List<String>> result, List<String> path) {
    path.add(0, endWord);
    if (endWord.equals(beginWord)) {
      result.add(path);
      return;
    }
    if (map.get(endWord) != null) {
      for (String w : map.get(endWord)) {
        helper(map, beginWord, w, result, new ArrayList<>(path));
      }
    }
  }



  public static void main(String[] args) {
    Prob126 prob126 = new Prob126();
    //System.out.println(prob126.findLadders("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));
    System.out.println(prob126.findLadders("hot", "dog", Arrays.asList(new String[]{"hot","dog"})));
  }
}
