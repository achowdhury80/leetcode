package com.leet.algo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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
    PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[1] - y[1]);
    heap.offer(new int[]{src, 0, 0});
    boolean[] explored = new boolean[n];
    //explored[src] = true;
    while (!heap.isEmpty()) {
      int[] path = heap.poll();
      if (explored[path[0]]) continue;
      explored[path[0]] = true;
      if (path[0] == dst && path[2] <= K + 1) return path[1];
      if (path[2] == K + 1) continue;
      if (map.containsKey(path[0])) {
        for (int[] next : map.get(path[0])) {
          if (explored[next[0]]) continue;
          heap.offer(new int[]{next[0], path[1] + next[1], path[2] + 1});
        }
      }

    }
    return -1;
  }

  public static void main(String[] args) {
    Prob787 prob787 = new Prob787();
    System.out.println(prob787.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
    System.out.println(prob787.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 0));
  }
}
