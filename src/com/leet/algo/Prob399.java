package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob399 {
  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    double[] result = new double[queries.length];
    Map<String, List<String>> leftMap = new HashMap<>();
    Map<String, List<String>> rightMap = new HashMap<>();
    Map<Equation, Double> equationValMap = new HashMap<>();
    for(int i = 0; i < queries.length; i++){
      if(!leftMap.containsKey(equations[i][0])){
        leftMap.put(equations[i][0], new ArrayList<>());
      }
      leftMap.get(equations[i][0]).add(equations[i][1]);
      if(!rightMap.containsKey(equations[i][1])){
        rightMap.put(equations[i][1], new ArrayList<>());
      }
      rightMap.get(equations[i][1]).add(equations[i][0]);
      equationValMap.put(new Equation(equations[i][0], equations[i][1]), values[i]);
    }
    for(int i = 0; i < queries.length; i++) result[i] = findAnswer(leftMap, rightMap, equationValMap, queries[i]);
    return result;
  }

  private double findAnswer(Map<String, List<String>> leftMap, Map<String, List<String>> rightMap,
                            Map<Equation, Double> equationValMap, String[] query){
    Equation eq = new Equation(query[0], query[1]);
    if(equationValMap.containsKey(eq)) return equationValMap.get(eq);
    Equation inv = new Equation(query[1], query[0]);
    if(equationValMap.containsKey(eq)) return 1.0 / equationValMap.get(eq);
    if(!leftMap.containsKey(query[0]) && !rightMap.containsKey(query[0]) ||
        !leftMap.containsKey(query[1]) && !rightMap.containsKey(query[1])) return -1;
    return 0;
  }
  class Equation {
    String left;
    String right;
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Equation equation = (Equation) o;

      if (left != null ? !left.equals(equation.left) : equation.left != null) return false;
      return right != null ? right.equals(equation.right) : equation.right == null;

    }

    @Override
    public int hashCode() {
      int result = left != null ? left.hashCode() : 0;
      result = 31 * result + (right != null ? right.hashCode() : 0);
      return result;
    }

    public Equation(String left, String right) {
      this.left = left;
      this.right = right;
    }
  }
}
