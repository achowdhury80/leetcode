package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ayanc on 1/15/18.
 */
public class Prob133 {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if(node == null) return null;
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    map.put(null, null);
    Queue<UndirectedGraphNode> q = new LinkedList<>();
    q.offer(node);
    Set<UndirectedGraphNode> explored = new HashSet<>();
    while (!q.isEmpty()){
      UndirectedGraphNode nd = q.poll();
      if(explored.contains(nd)) continue;
      explored.add(nd);
      UndirectedGraphNode newNd = new UndirectedGraphNode(nd.label);
      map.put(nd, newNd);
      for(UndirectedGraphNode child : nd.neighbors){
        if(child != null) {
          q.add(child);
        }
      }
    }
    q.offer(node);
    explored.clear();
    while (!q.isEmpty()){
      UndirectedGraphNode nd = q.poll();
      if(explored.contains(nd)) continue;
      explored.add(nd);
      UndirectedGraphNode newNd = map.get(nd);
      for(UndirectedGraphNode child : nd.neighbors){
        if(child != null) q.add(child);
        newNd.neighbors.add(map.get(child));
      }
    }

    return map.get(node);
  }

  static class UndirectedGraphNode {
         int label;
         List<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  }

  public static void main(String[] args){
    Prob133 prob133 = new Prob133();
    UndirectedGraphNode undirectedGraphNode = new UndirectedGraphNode(0);
    undirectedGraphNode.neighbors.add(undirectedGraphNode);
    undirectedGraphNode.neighbors.add(undirectedGraphNode);
    UndirectedGraphNode undirectedGraphNodeClone = prob133.cloneGraph(undirectedGraphNode);
  }
}
