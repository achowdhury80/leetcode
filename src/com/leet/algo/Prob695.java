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
        if(grid[i][j] == 1) {
          result = Math.max(result, findArea(grid, i, j, m, n));
        }
      }
    }
    return result;
  }

  private int findArea(int[][] grid, int i, int j, int m, int n){
    int result = 0;
    if(grid[i][j] == 1) result++;
    grid[i][j] = 0;
    if(i + 1 < m){
      if(grid[i + 1][j] == 1) {
        result += findArea(grid, i + 1, j, m, n);
      }
    }
    if(i - 1 > -1){
      if(grid[i - 1][j] == 1) {
        result += findArea(grid, i - 1, j, m, n);
      }
    }
    if(j + 1 < n){
      if(grid[i][j + 1] == 1) {
        result += findArea(grid, i, j + 1, m, n);
      }
    }
    if(j - 1 > - 1){
      if(grid[i][j - 1] == 1) {
        result += findArea(grid, i, j - 1, m, n);
      }
    }
    return result;
  }


  public static void main(String[] args){
    Prob695 prob695 = new Prob695();
    System.out.println(prob695.maxAreaOfIsland(new int[][]{{0}, {0}}));
  }

}
