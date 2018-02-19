package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 2/18/18.
 */
public class DagTester {
  private boolean findTopologicalOrder(int n, Map<Integer, List<Integer>> graph, List<Integer> result) {
    boolean[] explored = new boolean[n];
    boolean[] temp = new boolean[n];
    for (int node : graph.keySet()) if (!explored[node] && !visit(graph, explored, result, node, temp)) return false;
    return true;
  }

  private boolean visit(Map<Integer, List<Integer>> graph, boolean[] explored, List<Integer> result, int node, boolean[] temp){
    if (explored[node]) return true;
    if (temp[node]) {
      result.clear();
      return false;
    }
    temp[node] = true;
    if (graph.get(node) != null) {
      for (int next : graph.get(node)) if(!visit(graph, explored, result, next, temp)) return false;
    }
    explored[node] = true;
    result.add(0, node);
    return true;
  }

  public static void main(String[] args) {
    DagTester dagTester = new DagTester();
    List<Integer> result = new ArrayList<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    graph.put(5, Arrays.asList(2));
    graph.put(2, Arrays.asList(6));
    graph.put(6, Arrays.asList(3));
    graph.put(4, Arrays.asList(1));
    graph.put(1, Arrays.asList(5));
    //graph.put(0, Arrays.asList(2));
    System.out.println("is not dag: " + dagTester.findTopologicalOrder(7, graph, result));
    System.out.println(result);
  }
}
