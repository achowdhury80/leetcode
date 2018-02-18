package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 2/16/18.
 */
public class Prob244 {
  private Map<String, List<Integer>> wordIndexMap;
  public Prob244(String[] words) {
    wordIndexMap = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      if (!wordIndexMap.containsKey(words[i])) wordIndexMap.put(words[i], new ArrayList<>());
      wordIndexMap.get(words[i]).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> word1IndexList = wordIndexMap.get(word1);
    List<Integer> word2IndexList = wordIndexMap.get(word2);
    int result = Integer.MAX_VALUE;
    for (int i : word1IndexList) {
      for (int j : word2IndexList) {
        if (j > i && result <= j - i) {
          break;
        }
        result = Math.min(result, Math.abs(i - j));
      }
    }
    return result;
  }
}
