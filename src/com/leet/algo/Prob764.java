package com.leet.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob764 {
  public int orderOfLargestPlusSign(int N, int[][] mines) {
    if(N * N <= mines.length) return 0;
    int[][] grid = new int[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(grid[i], N);
    }

    for (int i = 0; i < mines.length; i++) grid[mines[i][0]][mines[i][1]] = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0, k = N - 1, left = 0, right = 0, up = 0, down = 0; j < N; j++, k--) {
        grid[i][j] = Math.min(grid[i][j], left = (grid[i][j] == 0 ? 0 : left + 1));
        grid[i][k] = Math.min(grid[i][k], right = (grid[i][k] == 0 ? 0 : right + 1));
        grid[j][i] = Math.min(grid[j][i], up = (grid[j][i] == 0 ? 0 : up + 1));
        grid[k][i] = Math.min(grid[k][i], down = (grid[k][i] == 0 ? 0 : down + 1));
      }
    }
    int result = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        result = Math.max(result, grid[i][j]);
      }
    }
    return result;

  }

  public static void main(String[] args) {
    Prob764 prob764 = new Prob764();
    System.out.println(prob764.orderOfLargestPlusSign(2, new int[][]{{0,0},{0,1}, {1,0}}));
  }




}
