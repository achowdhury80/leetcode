package com.leet.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by ayanc on 1/22/18.
 */
public class Prob139 {

  public boolean wordBreak(String s, List<String> wordDict) {
    if(wordDict == null || wordDict.size() < 1 || s == null || s.length() < 1) return false;
    return wordBreak(s, new HashSet<>(wordDict), new HashMap<>());
  }

  private boolean wordBreak(String s, Set<String> wordDict, Map<String, Boolean> map) {
    if ("".equals(s)) return true;
    if (map.containsKey(s)) return map.get(s);
    for (int i = 0; i < s.length(); i++) {
      if (wordDict.contains(s.substring(0, i + 1)) && wordBreak(s.substring(i + 1), wordDict, map)){
        map.put(s, true);
        return true;
      }
    }
    map.put(s, false);
    return false;
  }

  public boolean wordBreakUsingDP(String s, List<String> wordDict) {
    if(wordDict == null || wordDict.size() < 1 || s == null || s.length() < 1) return false;
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordDict.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[dp.length - 1];
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
