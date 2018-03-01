package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 2/26/18.
 */
public class Prob140 {
  public List<String> wordBreak(String s, List<String> wordDict) {
    Map<String, List<String>> map = new HashMap<>();
    List<String> result = dfs(s, new HashSet<>(wordDict), map);
    if (result == null) return new ArrayList<>();
    return result;
  }

  private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> map) {
    List<String> result = new ArrayList<>();
    if (map.containsKey(s)) return map.get(s);
    for (int i = 1; i <= s.length(); i++) {
      if (wordDict.contains(s.substring(0, i))) {
        String word = s.substring(0, i);
        if(i == s.length()){
          result.add(word);
        } else {
          List<String> sub = dfs(s.substring(i), wordDict, map);
          if (sub != null) {
            for (String str : sub) {
              result.add(word + " " + str);
            }
          }
        }
      }
    }
    if (result.isEmpty()) result = null;
    map.put(s, result);
    return result;
  }

  public static void main(String[] args) {
    Prob140 prob140 = new Prob140();
    System.out.println(prob140.wordBreak("catsanddog", Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"})));
  }
}
