package com.leet.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ayanc on 2/12/18.
 */
public class Prob286 {
  final int INF = Integer.MAX_VALUE;
  public void wallsAndGates(int[][] rooms) {
    int m, n;
    if (rooms == null || (m = rooms.length) < 1 || (n = rooms[0].length) < 1) return;
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < m; i++){
      for (int j = 0; j < n; j++) {
        if (rooms[i][j] == 0) q.add(new int[]{i, j});
      }
    }
    while (!q.isEmpty()) {
      int[] top = q.poll();
      List<int[]> nextPositions = nextPositions(rooms, top[0], top[1]);
      for (int[] nextPosition : nextPositions) {
        rooms[nextPosition[0]][nextPosition[1]] = rooms[top[0]][top[1]] + 1;
        q.add(nextPosition);
      }
    }
    return;
  }

  private List<int[]> nextPositions(int[][] rooms, int r, int c) {
    List<int[]> result = new ArrayList<>();
    if (r > 0 && rooms[r - 1][c] == INF) result.add(new int[]{r - 1, c});
    if (r < rooms.length - 1 && rooms[r + 1][c] == INF) result.add(new int[]{r + 1, c});
    if (c > 0 && rooms[r][c - 1] == INF) result.add(new int[]{r, c - 1});
    if (c < rooms[0].length - 1 && rooms[r][c + 1] == INF) result.add(new int[]{r, c + 1});
    return result;
  }

}
