package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 2/14/18.
 */
public class Prob261 {
  public boolean validTree(int n, int[][] edges) {
    if (n == 0) return false;
    Set<Integer> set = new HashSet<>();
    int[] parent = new int[n];
    int[] size = new int[n];
    for (int i = 0; i < n; i++) {
      set.add(i);
      parent[i] = -1;
    }
    for (int[] edge : edges) {
      int parent0 = find(edge[0], parent);
      int parent1 = find(edge[1], parent);
      if (parent0 != - 1 && parent0 == parent1) return false;
      union(edge[0], edge[1], parent, size, set);
    }
    return set.size() == 1;
  }

  private int find(int i, int[] parent) {
    if (parent[i] == -1) return -1;
    while (parent[i] != i) i = parent[i];
    return i;
  }

  private void union(int i, int j, int[] parent, int[] size, Set<Integer> set) {
    int pI = find(i, parent);
    if (pI == -1) {
      parent[i] = i;
      pI = i;
      size[i] = 1;
    }
    int pJ = find(j, parent);
    if (pJ == -1) {
      parent[j] = j;
      pJ = j;
      size[j] = 1;
    }
    if (pI == pJ) return;
    if (size[pI] >= size[pJ]) {
      parent[pJ] = pI;
      size[pI] += size[pJ];
      set.remove(pJ);
    } else {
      parent[pI] = pJ;
      size[pJ] += size[pI];
      set.remove(pI);
    }
  }

  public static void main(String[] args) {
    Prob261 prob261 = new Prob261();
    System.out.println(prob261.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
    System.out.println(prob261.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
  }
}
