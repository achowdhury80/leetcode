package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ayanc on 1/31/18.
 */
public class Prob699 {

  public List<Integer> fallingSquares(int[][] positions) {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    int maxHeight = 0;
    List<Integer> result = new ArrayList<>();
    treeMap.put(0, 0);
    for (int[] position : positions) {
      int start = position[0], end = position[0] + position[1];
      Integer key = treeMap.floorKey(start);
      int height = treeMap.get(key);
      key = treeMap.higherKey(key);
      while (key != null && key < end) {
        height = Math.max(height, treeMap.get(key));
        key = treeMap.higherKey(key);
      }
      height = height + position[1];
      maxHeight = Math.max(maxHeight, height);
      result.add(maxHeight);

      int tail = treeMap.floorEntry(end).getValue();
      treeMap.put(start, height);
      treeMap.put(end, tail);
      key = treeMap.higherKey(start);
      while (key != null && key < end) {
        treeMap.remove(key);
        key = treeMap.higherKey(key);
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob699 prob699 = new Prob699();
    System.out.println(prob699.fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}}));
    System.out.println(prob699.fallingSquares(new int[][]{{33,34}, {47,62}, {70,16}, {90,79}}));
    //[[33,34],[47,62],[70,16],[90,79],[73,86],[55,6],[74,2],[40,95],[52,16],[50,33]]
  }
}
