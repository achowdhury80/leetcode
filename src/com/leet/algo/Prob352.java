package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by ayanc on 1/30/18.
 */
public class Prob352 {
  TreeMap<Integer, Interval> tree;

  public Prob352() {
    tree = new TreeMap<>();
  }

  public void addNum(int val) {
    if (tree.containsKey(val)) return;
    Integer lower = tree.lowerKey(val);
    Integer higher = tree.higherKey(val);
    if(lower != null && higher != null && tree.get(lower).end + 1 == val && higher - 1 == val){
      tree.get(lower).end = tree.get(higher).end;
      tree.remove(higher);
    } else if(lower != null && tree.get(lower).end + 1 >= val) tree.get(lower).end = Math.max(tree.get(lower).end, val);
    else if(higher != null && higher == val + 1) {
      tree.put(val, new Interval(val, tree.get(higher).end));
      tree.remove(higher);
    } else tree.put(val, new Interval(val, val));
  }

  public List<Interval> getIntervals() {
    return new ArrayList<>(tree.values());
  }

  class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
      return "Interval{" +
          "start=" + start +
          ", end=" + end +
          '}';
    }
  }

  public static void main(String[] args){
    Prob352 prob352 = new Prob352();
    prob352.addNum(1);
    System.out.println(prob352.getIntervals());
    prob352.addNum(3);
    System.out.println(prob352.getIntervals());
    prob352.addNum(7);
    System.out.println(prob352.getIntervals());
    prob352.addNum(2);
    System.out.println(prob352.getIntervals());
    prob352.addNum(6);
    System.out.println(prob352.getIntervals());
  }
}
