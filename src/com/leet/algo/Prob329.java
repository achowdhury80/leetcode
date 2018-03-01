package com.leet.algo;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob329 {
  public int longestIncreasingPath(int[][] matrix) {
    int m, n;
    if (matrix == null || (m = matrix.length) < 1 || (n = matrix[0].length) < 1) return 0;
    int result = 0;
    int[][] cache = new int[m][n];
    int[][] dirs = new int[][]{new int[]{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result = Math.max(result, dfs(matrix, i, j, cache, dirs, m, n));
      }
    }
    return result;
  }

  private int dfs(int[][] matrix, int i, int j, int[][] cache, int[][] dirs, int m, int n){
    if (cache[i][j] != 0) return cache[i][j];
    int max = 1;
    for (int[] dir : dirs) {
      int x = i + dir[0], y = j + dir[1];
      if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[i][j]) continue;
      int len = 1 + dfs(matrix, x, y, cache, dirs, m, n);
      max = Math.max(max, len);
    }
    cache[i][j] = max;
    return max;
  }

  public static void main(String[] args) {
    Prob329 prob329 = new Prob329();
    System.out.println(prob329.longestIncreasingPath(new int[][]{
        {9,9,4},
        {6,6,8},
        {2,1,1}}));
    System.out.println(prob329.longestIncreasingPath(new int[][]{
        {3,4,5},
        {3,2,6},
        {2,2,1}}));

    System.out.println(prob329.longestIncreasingPath(new int[][]{
        {7, 8, 9},
        {9, 7, 6},
        {7, 2, 3}}));
  }
}
