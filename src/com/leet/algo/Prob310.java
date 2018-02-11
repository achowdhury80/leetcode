package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 2/8/18.
 */
public class Prob310 {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> result = new ArrayList<>();
    if (n == 0) return result;
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      if (!map.containsKey(edge[0])) map.put(edge[0], new HashSet<>());
      if (!map.containsKey(edge[1])) map.put(edge[1], new HashSet<>());
      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }
    Set<Integer>[] dp = new Set[n];
    for (int i = 0; i < n; i++) {
      
    }
    return null;
  }
}
