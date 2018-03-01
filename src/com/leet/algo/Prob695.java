package com.leet.algo;

/**
 * Created by ayanc on 1/25/18.
 */
public class Prob695 {
  public int maxAreaOfIsland(int[][] grid) {
    int m, n;
    if(grid == null || (m = grid.length) < 1 || (n = grid[0].length) < 1) return 0;
    int result = 0;
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(grid[i][j] == 1) result = Math.max(result, maxAreaOfIsland(grid, i, j));
      }
    }
    return result;
  }

  private int maxAreaOfIsland(int[][] grid, int i, int j) {
    if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
      grid[i][j] = 0;
      return 1 + maxAreaOfIsland(grid, i - 1, j) + maxAreaOfIsland(grid, i + 1, j) + maxAreaOfIsland(grid, i, j - 1)
          + maxAreaOfIsland(grid, i, j + 1);
    }
    return 0;
  }

  public static void main(String[] args){
    Prob695 prob695 = new Prob695();
    System.out.println(prob695.maxAreaOfIsland(new int[][]{{0}, {0}}));
  }

}
