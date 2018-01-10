package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 1/9/18.
 */
public class Prob685 {
  public int[] findRedundantDirectedConnection(int[][] edges) {
    if(edges == null || edges.length == 0) return new int[2];
    int[] parent = new int[edges.length + 1];
    int[][] candidates = new int[2][2];
    int[] root = new int[edges.length + 1];
    for(int i = 0; i < edges.length; i++) {
      if (parent[edges[i][1]] == 0) {
        parent[edges[i][1]] = edges[i][0];
      } else {
        candidates[0] = edges[i];
        candidates[1] = new int[]{parent[edges[i][1]], edges[i][1]};
        continue;
      }
    }
    for(int i = 0; i < edges.length; i++){
      if(parent[edges[i][1]] != edges[i][0]){
        continue;
      }
      if(root[edges[i][0]] == 0){
        root[edges[i][0]] = edges[i][0];
      }
      if(root[edges[i][1]] == 0){
        root[edges[i][1]] = edges[i][1];
      }
      if(find(root, edges[i][0]) == find(root, edges[i][1])) {
        if(candidates[0][0] != 0){
          return candidates[1];
        } else {
          return edges[i];
        }
      }
      else union(root, edges[i][0], edges[i][1]);
    }
    return candidates[0];

  }

  private int find(int[] root, int node){
    return root[node] == node ? root[node] : find(root, root[node]);
  }

  private void union(int[] root, int node1, int node2){
    int parent1 = find(root, node1);
    int parent2 = find(root, node2);
    root[parent2] = parent1;
  }

  public static void main(String[] args){
    Prob685 prob685 = new Prob685();
    int[] edge = null;
    edge = prob685.findRedundantDirectedConnection(new int[][]{{1,2}, {1,3}, {2,3}});
    System.out.println(edge[0] + " -> " + edge[1]);
    edge = prob685.findRedundantDirectedConnection(new int[][]{{1,2}, {2,3}, {3,4}, {4,1}, {1,5}});
    System.out.println(edge[0] + " -> " + edge[1]);
    edge = prob685.findRedundantDirectedConnection(new int[][]{{2,1},{3,1},{4,2},{1,4}});
    System.out.println(edge[0] + " -> " + edge[1]);
    edge = prob685.findRedundantDirectedConnection(new int[][]{{3,4},{4,1},{1,2},{2,3},{5,1}});
    System.out.println(edge[0] + " -> " + edge[1]);
  }
}
