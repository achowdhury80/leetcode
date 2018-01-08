package com.leet.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 1/4/18.
 */
public class Prob684 {
  public int[] findRedundantConnection(int[][] edges) {
    Map<Integer, Integer> anchestor = new HashMap<>();
    for(int[] edge : edges){
      Integer leftAnchestor = findAnchestor(anchestor, edge[0]);
      Integer rightAnchestor = findAnchestor(anchestor, edge[1]);
      if(leftAnchestor != null && rightAnchestor != null && leftAnchestor.equals(rightAnchestor)) return edge;
      if(!anchestor.containsKey(edge[0]) && !anchestor.containsKey(edge[1])){
        anchestor.put(edge[0], edge[0]);
        anchestor.put(edge[1], edge[0]);
      } else if(!anchestor.containsKey(edge[0])){
        anchestor.put(edge[0], rightAnchestor);
      } else if(!anchestor.containsKey(edge[1])){
        anchestor.put(edge[1], leftAnchestor);
      } else {
        if(leftAnchestor > rightAnchestor){
          anchestor.put(leftAnchestor, rightAnchestor);
        } else {
          anchestor.put(rightAnchestor, leftAnchestor);
        }
      }
    }
    return null;
  }

  private Integer findAnchestor(Map<Integer, Integer> anchestor, int node){
    if(!anchestor.containsKey(node)) return null;
    while(anchestor.get(node) != node){
      node = anchestor.get(node);
    }
    return node;
  }

}
