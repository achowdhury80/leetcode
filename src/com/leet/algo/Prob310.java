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
    Map<Integer, Integer> heightMap = new HashMap<>();
    int minHeight = Integer.MAX_VALUE;
    for (int key : map.keySet()) {
      minHeight = Math.min(minHeight, findMinHeightTrees(map, heightMap, key));
    }
    for (int key : heightMap.keySet()) {
      if (heightMap.get(key) == minHeight) result.add(key);
    }
    return result;
  }

  public int findMinHeightTrees(Map<Integer, Set<Integer>> map, Map<Integer, Integer> heightMap, int key) {
    if (heightMap.containsKey(key)) return heightMap.get(key);
    int height = 0;
    heightMap.put(key, height);
    for (int next : map.get(key)) {
      height =  Math.max(height, 1 + findMinHeightTrees(map, heightMap, next));
    }
    heightMap.put(key, height);
    return height;
  }

  public static void main(String[] args) {
    Prob310 prob310 = new Prob310();
    System.out.println(prob310.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
  }

}
