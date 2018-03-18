package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob797 {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    if (graph == null || graph.length < 1) return new ArrayList<>();
    Map<Integer, List<List<Integer>>> map = new HashMap<>();
    allPathsSourceTarget(graph, 0, graph.length - 1, map);
    return map.get(0);
  }

  private List<List<Integer>> allPathsSourceTarget(int[][] graph, int start, int end, Map<Integer, List<List<Integer>>> map) {
    List<List<Integer>> result = new ArrayList<>();
    if (map.containsKey(start)) return map.get(start);
    if (start == end) {
      List<Integer> list = new ArrayList<>();
      list.add(end);
      result.add(list);
      return result;
    }
    int[] nexts = graph[start];
    if (nexts != null && nexts.length > 0) {
      for (int next : nexts) {
        List<List<Integer>> paths = allPathsSourceTarget(graph, next, end, map);
        if (paths != null) {
          for (List<Integer> path : paths) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(0, start);
            result.add(newPath);
          }
          map.put(start, result);
        }
      }
    }
    return map.get(start);
  }

  public static void main(String[] args) {
    Prob797 prob797 = new Prob797();
    System.out.println(prob797.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
  }
}
