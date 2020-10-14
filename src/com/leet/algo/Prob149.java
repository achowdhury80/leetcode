package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 2/27/18.
 */
public class Prob149 {
  public int maxPoints(Point[] points) {
    if (points == null || points.length < 1) return 0;
    int result = 0;
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int i = 0; i < points.length - 1; i++) {
      map.clear();
      int samePoint = 0;
      int max = 0;
      for (int j = i + 1; j < points.length; j++) {
        int x = points[i].x - points[j].x;
        int y = points[i].y - points[j].y;
        if (x == 0 && y == 0) samePoint++;
        else {
          int gcd = gcd(x, y);
          if (gcd != 0) {
            x /= gcd;
            y /= gcd;
          }
          if (map.containsKey(x)) {
            if (map.get(x).containsKey(y)) {
              map.get(x).put(y, map.get(x).get(y) + 1);
            } else map.get(x).put(y, 1);
          } else {
            Map<Integer, Integer> m = new HashMap<>();
            m.put(y, 1);
            map.put(x, m);
          }
          max = Math.max(max, map.get(x).get(y));
        }
      }
      result = Math.max(result, max + samePoint + 1);
    }
    return result;
  }

  private int gcd(int x, int y) {
    if (x < y) return gcd(y, x);
    if (y == 0) return x;
    return gcd(y, x % y);
  }

  static class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
  }

  public static void main(String[] args) {
    Prob149 prob149 = new Prob149();
    System.out.println(prob149.maxPoints(new Point[]{new Point(2, 3), new Point(3, 3), new Point(-5, 3)}));
  }
}
