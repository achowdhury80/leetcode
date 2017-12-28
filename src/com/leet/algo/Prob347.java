package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by ayanc on 12/8/17.
 */
public class Prob347 {
  public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> result = new ArrayList<>();
    if(nums == null || nums.length == 0 || k == 0) return result;
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(nums).forEach(i -> map.put(i , (map.get(i) == null ? 1 : map.get(i) + 1)));
    List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
      @Override
      public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
        return e2.getValue().compareTo(e1.getValue());
      }
    });
    return list.stream().limit(k).map(x -> x.getKey()).collect(Collectors.toList());
  }

  public static void main(String[] args){
    Prob347 prob347 = new Prob347();
    System.out.println(prob347.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
  }
}
