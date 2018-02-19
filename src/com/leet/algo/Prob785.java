package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 2/17/18.
 */
public class Prob785 {
  public boolean isBipartite(int[][] graph) {
    if (graph == null || graph.length < 1) return false;
    Set<Integer> a = new HashSet<>();
    Set<Integer> b = new HashSet<>();
    a.add(0);
    for (int j = 0; j < graph[0].length; j++) {
      b.add(graph[0][j]);
    }
    return isBipartite(graph, new Set[]{a, b}, 1);
  }

  public boolean isBipartite(int[][] graph, Set<Integer>[] sets, int start) {
    if (start >= graph.length) return true;
    for (int i = start; i < graph.length; i++) {
      int[] pos = setAssignment(i, graph[i], sets);
      if (pos != null) {
        if (sets[pos[1]].contains(i)) return false;
        else sets[pos[0]].add(i);
        for (int j = 0; j < graph[i].length; j++) {
          if (sets[pos[0]].contains(graph[i][j])) return false;
          else sets[pos[1]].add(graph[i][j]);
        }
      } else {
        sets[0].add(i);
        for (int j = 0; j < graph[i].length; j++) {
          sets[1].add(graph[i][j]);
        }
        if (isBipartite(graph, sets, i + 1)) return true;
        for (int j = 0; j < graph[i].length; j++) {
          sets[1].remove(new Integer(graph[i][j]));
        }
        sets[0].remove(new Integer(i));
        for (int j = 0; j < graph[i].length; j++) {
          sets[0].add(graph[i][j]);
        }
        sets[0].add(i);
        if (isBipartite(graph, sets, i + 1)) return true;
        return false;
      }
    }
    return true;
  }

  private int[] setAssignment(int left, int[] right, Set<Integer>[] sets) {
    if (sets[0].contains(left)) return new int[]{0, 1};
    if (sets[1].contains(left)) return new int[]{1, 0};
    for (int i = 0; i < right.length; i++) {
      if (sets[0].contains(right[i])) return new int[]{1, 0};
      if (sets[1].contains(right[i])) return new int[]{0, 1};
    }
    return null;
  }

  public static void main(String[] args) {
    Prob785 prob785 = new Prob785();
    System.out.println(prob785.isBipartite(new int[][]{{1,3}, {0,2}, {1,3}, {0,2}}));
    System.out.println(prob785.isBipartite(new int[][]{{1,2,3}, {0,2}, {0, 1,3}, {0,2}}));
  }
}
