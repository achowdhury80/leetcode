package com.leet.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 2/14/18.
 */
public class Prob356 {
  public boolean isReflected(int[][] points) {
    if (points.length < 2) return true;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    Set<String> set = new HashSet<>();
    for (int[] point : points) {
      min = Math.min(min, point[0]);
      max = Math.max(max, point[0]);
      set.add(point[0] + "a" + point[1]);
    }
    int sum = max + min;
    for (int[] point : points) {
      if (!set.contains((sum - point[0]) + "a" + point[1])) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Prob356 prob356 = new Prob356();
    System.out.println(prob356.isReflected(new int[][]{{1, 1}, {-1, 1}}));
    System.out.println(prob356.isReflected(new int[][]{{1, 1}, {-1, -1}}));
    System.out.println(prob356.isReflected(new int[][]{{-16, 1}, {16, 1}, {16, 1}}));
  }
}
