package com.leet.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ayanc on 2/21/18.
 */
public class Prob301 {
  public List<String> removeInvalidParentheses(String s) {
    List<String> result = new ArrayList<>();
    if (s == null) return result;
    Set<String> visited = new HashSet<>();
    Queue<String> q = new LinkedList<>();
    q.add(s);
    visited.add(s);
    boolean found = false;
    while (!q.isEmpty()) {
       s = q.poll();
      if (isValid(s)) {
        result.add(s);
        found = true;
      }
      if (found) continue;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
        String st = s.substring(0, i) + s.substring(i + 1);
        if (!visited.contains(st)) {
          q.add(st);
          visited.add(st);
        }
      }
    }
    return result;
  }

  private boolean isValid(String s) {
    int count = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') count++;
      else if (c == ')' && count-- == 0) return false;
    }
    return count == 0;
  }
}
