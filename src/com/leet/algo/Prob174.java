package com.leet.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ayanc on 2/27/18.
 */
public class Prob174 {
  public int calculateMinimumHP(int[][] dungeon) {
    int m, n;
    if(dungeon == null || (m = dungeon.length) < 1 || (n = dungeon[0].length) < 1) return 0;
    int[][] dp = new int[m][n];
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{m - 1, n - 1});
    dp[m - 1][n - 1] = dungeon[m - 1][n - 1] < 0 ? 1 - dungeon[m - 1][n - 1] : 1;
    while (!q.isEmpty()) {
      int[] current = q.poll();
      int i = current[0];
      int j = current[1];
      if (i - 1 > -1) {
        if (dp[i - 1][j] == 0 || dp[i][j] - dungeon[i - 1][j] < dp[i - 1][j]) {
          if (dp[i][j] - dungeon[i - 1][j] <= 0) {
            dp[i - 1][j] = 1;
          } else {
            dp[i -1][j] = dp[i][j] - dungeon[i - 1][j];
          }
          q.offer(new int[]{i - 1, j});
        }
      }
      if (j - 1 > -1) {
        if (dp[i][j - 1] == 0 || dp[i][j] - dungeon[i][j - 1] < dp[i][j - 1]) {
          if (dp[i][j] - dungeon[i][j - 1] <= 0) {
            dp[i][j - 1] = 1;
          } else {
            dp[i][j - 1] = dp[i][j] - dungeon[i][j - 1];
          }
          q.offer(new int[]{i, j - 1});
        }
      }
    }
    return dp[0][0];
  }
}
