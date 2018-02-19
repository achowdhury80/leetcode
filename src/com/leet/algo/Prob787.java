package com.leet.algo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 2/17/18.
 */
public class Prob787 {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    if(src == dst) return 0;
    Map<Integer, List<int[]>> map = new HashMap<>();
    for (int i = 0; i < flights.length; i++) {
      if (!map.containsKey(flights[i][0])) map.put(flights[i][0], new ArrayList<>());
      map.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
    }
    for (int key : map.keySet()) {
      Collections.sort(map.get(key), (x, y) -> x[1] - y[1]);
    }
    boolean[] vis = new boolean[n];
    vis[src] = true;
    return findCheapestPrice(src, dst, K, map, 0, vis);
  }

  private int findCheapestPrice(int start, int end, int k, Map<Integer, List<int[]>> map, int price, boolean[] vis) {
    if (start == end) return price;
    if (!map.containsKey(start) || k < 0) return -1;
    List<int[]> nextDestinations = map.get(start);
    boolean found = false;
    int result = -1;
    for (int[] next : nextDestinations) {
      if (found && next[1] >= result - price || vis[next[0]]) continue;
      vis[next[0]] = true;
      int res = findCheapestPrice(next[0], end, k - 1, map, price + next[1], vis);
      if (res != -1) {
        if (!found) {
          found = true;
          result = res;
        } else result = Math.min(result, res);
      }
      vis[next[0]] = false;
    }
    return result;
  }

  public static void main(String[] args) {
    Prob787 prob787 = new Prob787();
    System.out.println(prob787.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
    System.out.println(prob787.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 0));
  }
}
