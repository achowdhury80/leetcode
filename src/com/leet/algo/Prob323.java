package com.leet.algo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob323 {
  public int countComponents(int n, int[][] edges) {
    int[] parent = new int[n];
    Set<Integer> set = new HashSet<>();
    IntStream.range(0, n).forEach(idx -> {
      parent[idx] = -1;
      set.add(idx);
    });
    for (int[] edge : edges) union(parent, set, edge);
    return set.size();
  }

  private int findParent(int[] parent, int node) {
    if (parent[node] == -1) return -1;
    while (parent[node] != node){
      node = parent[node];
    }
    return node;
  }

  private void union(int[] parent, Set<Integer> set, int[] edge) {
    int parent0 = findParent(parent, edge[0]);
    if (parent0 == -1) {
      parent[edge[0]] = edge[0];
      parent0 = edge[0];
    }
    int parent1 = findParent(parent, edge[1]);
    if (parent1 == -1) {
      parent[edge[1]] = edge[1];
      parent1 = edge[1];
    }
    if(parent0 != parent1) {
      parent[parent1] = parent0;
      set.remove(parent1);
    }
  }

  public static void main(String[] args) {
    Prob323 prob323 = new Prob323();
    System.out.println(prob323.countComponents(5, new int[][]{{0,1},{1,2},{0,2},{3,4}}));
    System.out.println(prob323.countComponents(4, new int[][]{{2, 3},{1,2},{1,3}}));
  }
}
