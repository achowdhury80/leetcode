package com.leet.algo;

import java.util.List;

/**
 * Created by ayanc on 2/17/18.
 */
public class Prob469 {
  public boolean isConvex(List<List<Integer>> points) {
    int n;
    if(points == null || (n = points.size()) < 3) return false;
    int flag = 0;
    for (int i = 0; i < n; i++) {
      int direction = findDirection(points, i);
      if (direction == 0) continue;
      if (flag == 0) flag = direction > 0 ? 1 : -1;
      else if(flag > 0 != direction > 0) return false;
    }
    return true;
  }

  private int findDirection(List<List<Integer>> points, int i) {
    List<Integer> a = points.get(i);
    List<Integer> b = points.get((i + 1) % points.size());
    List<Integer> c = points.get((i + 2) % points.size());
    return (a.get(1) - b.get(1)) * (b.get(0) - c.get(0)) - (b.get(1) - c.get(1)) * (a.get(0) - b.get(0));
  }
}
