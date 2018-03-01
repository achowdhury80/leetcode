package com.leet.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ayanc on 2/22/18.
 */
public class Prob126 {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    if (beginWord.equals(endWord)) {
      List<String> list = new ArrayList<>();
      list.add(beginWord);
      result.add(list);
      return result;
    }
    Set<String> words = new HashSet<>();
    for (String word : wordList) words.add(word);
    words.add(endWord);
    Queue<String> q = new LinkedList();
    Queue<String> qTemp = new LinkedList();
    q.add(beginWord);
    List<List<String>> temp = new ArrayList<>();
    temp.add(new ArrayList<>());
    while (!q.isEmpty()) {
      while (!q.isEmpty()) {

      }
      q = qTemp;
    }
    return result;
  }
}
