package com.leet.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ayanc on 1/15/18.
 */
public class Prob127 {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList), vis = new HashSet<>();
    Queue<String> q = new LinkedList<>();
    q.offer(beginWord);
    for (int len = 1; !q.isEmpty(); len++) {
      for (int i = q.size(); i > 0; i--) {
        String w = q.poll();
        if (w.equals(endWord)) return len;

        for (int j = 0; j < w.length(); j++) {
          char[] ch = w.toCharArray();
          for (char c = 'a'; c <= 'z'; c++) {
            if (c == w.charAt(j)) continue;
            ch[j] = c;
            String nb = String.valueOf(ch);
            if (dict.contains(nb) && vis.add(nb)) q.offer(nb);
          }
        }
      }
    }
    return 0;

  }


  public static void main(String[] args){
    Prob127 prob127 = new Prob127();
    List<String> list = new ArrayList<>();
    list.add("hot");
    list.add("dot");
    list.add("dog");
    list.add("lot");
    list.add("log");
    list.add("cog");
    System.out.println(prob127.ladderLength("hit", "cog", list));
  }
}
