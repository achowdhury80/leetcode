package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ayanc on 2/15/18.
 */
public class Prob694 {
  private static final int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  public int numDistinctIslands(int[][] grid) {
    int m, n;
    if (grid == null || (m = grid.length) < 1 || (n = grid[0].length) < 1) return 0;
    Set<List<List<Integer>>> set = new HashSet<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        List<List<Integer>> island = new ArrayList<>();
        if (dfs(i, j, i, j, grid, island)) set.add(island);
      }
    }
    return set.size();

  }

  private boolean dfs(int i0, int j0, int i, int j, int[][] grid, List<List<Integer>> island) {
    if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] < 1) return false;
    island.add(Arrays.asList(i - i0, j - j0));
    grid[i][j] *= -1;
    for (int[] dir : dirs) dfs(i0, j0, i + dir[0], j + dir[1], grid, island);
    return true;
  }
}
