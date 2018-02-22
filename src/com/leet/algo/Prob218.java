package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by ayanc on 2/20/18.
 */
public class Prob218 {
  public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> result = new ArrayList<>();
    if (buildings == null || buildings.length < 1) return result;
    BuildingPoint[] points = new BuildingPoint[buildings.length * 2];
    for (int i = 0; i < buildings.length; i++) {
      points[2 * i] = new BuildingPoint(buildings[i][0], buildings[i][2], true);
      points[2 * i + 1] = new BuildingPoint(buildings[i][1], buildings[i][2], false);
    }
    Arrays.sort(points);
    TreeMap<Integer, Integer> map = new TreeMap<>();
    map.put(0, 1);
    int maxVal = 0;
    for (BuildingPoint point : points) {
      if (point.start) {
        map.put(point.height, map.getOrDefault(point.height, 0) + 1);
        int last = map.lastKey();
        if (last != maxVal) {
          result.add(new int[]{point.x, last});
          maxVal = last;
        }
      } else {
        if (map.get(point.height) == 1) map.remove(point.height);
        else map.put(point.height, map.get(point.height) - 1);
        int last = map.lastKey();
        if (last != maxVal) {
          result.add(new int[]{point.x, last});
          maxVal = last;
        }
      }
    }
    return result;
  }

  class BuildingPoint implements Comparable<BuildingPoint>{
    int x, height;
    boolean start;
    BuildingPoint(int x, int height, boolean start) {
      this.x = x;
      this.height = height;
      this.start = start;
    }

    public int compareTo(BuildingPoint other) {
      if (this.x == other.x) {
        if (this.start && other.start) return other.height - this.height;
        if (!this.start && !other.start) return this.height - other.height;
        return this.start ? -1 : 1;
      }
      return this.x - other.x;
    }

  }



  public static void main(String[] args){
    Prob218 prob218 = new Prob218();
    List<int[]> result = null;
    result = prob218.getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12},
        {15, 20, 10}, {19, 24, 8}});
    for (int i = 0; i < result.size(); i++) {
      System.out.print("(" + result.get(i)[0] + ","+ result.get(i)[1] +"), ");
    }
    System.out.println();
    result = prob218.getSkyline(new int[][]{{1, 2, 1}, {1, 2, 2}, {1, 2, 3}});
    for (int i = 0; i < result.size(); i++) {
      System.out.print("(" + result.get(i)[0] + ","+ result.get(i)[1] +"), ");
    }
  }
}
