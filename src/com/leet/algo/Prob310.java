package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by ayanc on 2/8/18.
 */
public class Prob310 {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> result = new ArrayList<>();
    if (n == 0) return result;
    if (n == 1){
      result.add(0);
      return result;
    }
    Map<Integer, List<Integer>> map = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      if (!map.containsKey(edges[i][0])) map.put(edges[i][0], new ArrayList<>());
      inDegree.put(edges[i][0], inDegree.getOrDefault(edges[i][0], 0) + 1);
      map.get(edges[i][0]).add(edges[i][1]);
      if (!map.containsKey(edges[i][1])) map.put(edges[i][1], new ArrayList<>());
      inDegree.put(edges[i][1], inDegree.getOrDefault(edges[i][1], 0) + 1);
      map.get(edges[i][1]).add(edges[i][0]);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 1) queue.offer(entry.getKey());
    }
    while (!queue.isEmpty()) {
      if (map.size() < 3) {
        for (int key : map.keySet()) result.add(key);
        break;
      }
      Queue<Integer> temp = new LinkedList<>();
      while (!queue.isEmpty()) {
        int node = queue.poll();
        for (int next : map.get(node)) {
          if (inDegree.containsKey(next)) {
            int degree = inDegree.get(next) - 1;
            inDegree.put(next, degree);
            if (degree == 1) temp.offer(next);
          }
        }
        map.remove(node);
        inDegree.remove(node);
      }
      queue = temp;
    }
    return result;

  }

  public static void main(String[] args) {
    Prob310 prob310 = new Prob310();
    System.out.println(prob310.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
    System.out.println(prob310.findMinHeightTrees(4, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}));
  }

}
