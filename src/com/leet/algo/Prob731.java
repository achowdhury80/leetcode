package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob731 {
  private TreeMap<Integer, Integer> treeMap;
  public Prob731() {
    treeMap = new TreeMap<>();
    treeMap.put(0, 0);
  }

  public boolean book(int start, int end) {
    Map.Entry<Integer, Integer> leftMostEntry = treeMap.floorEntry(start);
    Map.Entry<Integer, Integer> higher = treeMap.ceilingEntry(end);
    int lastRightValue = leftMostEntry.getValue();
    if(leftMostEntry.getValue() == 2) return false;
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
    Map.Entry<Integer, Integer> entry = treeMap.higherEntry(leftMostEntry.getKey());
    while(entry != null && entry.getKey() < end){
      if(entry.getValue() == 2) return false;
      list.add(entry);
      entry = treeMap.higherEntry(entry.getKey());
    }
    treeMap.put(start, leftMostEntry.getValue() + 1);
    Map.Entry<Integer, Integer> rightMost = null;
    if (!list.isEmpty()) {
      rightMost = list.get(list.size() - 1);
      lastRightValue = rightMost.getValue();
    }
    for (Map.Entry<Integer, Integer> entry1 : list) {
      treeMap.put(entry1.getKey(), entry1.getValue() + 1);
    }
    //Map.Entry<Integer, Integer> higher = treeMap.ceilingEntry(rightMost != null ? rightMost.getKey() : leftMostEntry.getKey());
    if(higher == null || higher.getKey() != end){
      treeMap.put(end, lastRightValue);
    }
    return true;
  }

  public static void main(String[] args){
    Prob731 prob731 = new Prob731();
    System.out.println(prob731.book(10, 20)); // returns true
    System.out.println(prob731.book(50, 60)); // returns true
    System.out.println(prob731.book(10, 40)); // returns true
    System.out.println(prob731.book(5, 15)); // returns false
    System.out.println(prob731.book(5, 10)); // returns true
    System.out.println(prob731.book(25, 55)); // returns true
    System.out.println();
  }
}
