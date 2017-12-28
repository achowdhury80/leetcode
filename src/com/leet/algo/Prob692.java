package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 12/7/17.
 */
public class Prob692 {
  public List<String> topKFrequent(String[] words, int k) {
    List<String> result = new ArrayList<>();
    if(words == null || words.length < 1 || k < 1) return result;
    Map<String, Integer> map = new HashMap<>();
    Arrays.stream(words).forEach(word -> {
      map.put(word, map.get(word) == null ? 1 : map.get(word) + 1);
    });
    List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
    Collections.sort( list, new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        int cmp1 = o2.getValue().compareTo(o1.getValue());
        if(cmp1 != 0) return cmp1;
        return o1.getKey().compareTo(o2.getKey());
      }
    });
    int count = 0;
    for(int i = 0; i < list.size() && count < k; i++){
      result.add(list.get(i).getKey());
      count++;
    }
    return result;
  }

  public static void main(String[] args){
    System.out.println(new Prob692().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
  }
}
