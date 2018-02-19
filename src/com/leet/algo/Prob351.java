package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 2/13/18.
 */
public class Prob351 {
  public int numberOfPatterns(int m, int n) {
    int[][] skip = new int[10][10];
    skip[1][3] = skip[3][1] = 2;
    skip[1][7] = skip[7][1] = 4;
    skip[3][9] = skip[9][3] = 6;
    skip[7][9] = skip[9][7] = 8;
    skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
    boolean[] vis = new boolean[10];
    int result = 0;
    for (int i = m; i <= n; i++) {
      result += dfs(vis, skip, 1, i - 1) * 4;
      result += dfs(vis, skip, 2, i - 1) * 4;
      result += dfs(vis, skip, 5, i - 1);
    }
    return result;
  }

  private int dfs(boolean[] vis, int[][] skip, int cur, int remain) {
    if (remain < 0) return 0;
    if (remain == 0) return 1;
    vis[cur] = true;
    int res = 0;
    for (int i = 1; i < 10; i++) {
      if (!vis[i] && (skip[cur][i] == 0 || vis[skip[cur][i]])) res += dfs(vis, skip, i, remain - 1);
    }
    vis[cur] = false;
    return res;
  }

  public static void main(String[] args) {
    Prob351 prob351 = new Prob351();
    //System.out.println(prob351.numberOfPatterns(1, 1));
    System.out.println(prob351.numberOfPatterns(1, 2));
  }
}
