package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob399 {
  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    double[] result = new double[queries.length];
    Map<String, Node> nodeMap = new HashMap<>();
    populateNodeMap(nodeMap, equations, values);
    for (int i = 0; i < queries.length; i++) {
      if (!nodeMap.containsKey(queries[i][0]) || !nodeMap.containsKey(queries[i][1])) result[i] = -1.0d;
      else result[i] = executeQuery(nodeMap, queries[i], new HashSet<>(), 1.0);
    }
    return result;
  }

  class Node {
    String label;
    Map<Node, Double> map = new HashMap<>();
    public Node(String label) {
      this.label = label;
    }
  }

  private double executeQuery(Map<String, Node> nodeMap, String[] query, Set<String> explored, double currentValue){
    if (query[0].equals(query[1])) {
      explored.add(query[0]);
      return currentValue;
    }
    explored.add(query[1]);
    for (Node node : nodeMap.get(query[1]).map.keySet()) {
      if (explored.contains(node.label)) continue;
      double result = executeQuery(nodeMap, new String[]{query[0], node.label}, explored,
          currentValue * nodeMap.get(query[1]).map.get(node));
      if (result != -1) return result;
    }
    return -1.0d;
  }

  private void populateNodeMap(Map<String, Node> nodeMap, String[][] equations, double[] values){
    for (int i = 0; i < equations.length; i++) {
      if (!nodeMap.containsKey(equations[i][0])) nodeMap.put(equations[i][0], new Node(equations[i][0]));
      if (!nodeMap.containsKey(equations[i][1])) nodeMap.put(equations[i][1], new Node(equations[i][1]));
      Node first = nodeMap.get(equations[i][0]);
      Node second = nodeMap.get(equations[i][1]);
      second.map.put(first, values[i]);
      first.map.put(second, 1.0d /values[i]);
    }
  }

  public static void main(String[] args) {
    Prob399 prob399 = new Prob399();
    double[] result = null;
//    result = prob399.calcEquation(new String[][]{{"a","b"},{"b","c"}}, new double[]{2.0,3.0},
//        new String[][]{{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}});
//    for (int i = 0; i < result.length; i++) System.out.print(result[i] + ",");

    result = prob399.calcEquation(new String[][]{{"a","b"},{"b","c"}}, new double[]{2.0,3.0},
        new String[][]{{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}});
    for (int i = 0; i < result.length; i++) System.out.print(result[i] + ",");
  }
}
