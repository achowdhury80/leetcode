package com.leet.algo;

import java.util.*;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob317 {
	public int shortestDistance(int[][] grid) {
	    int m, n;
	    if (grid == null || (m = grid.length) < 1 || (n = grid[0].length) < 1) return -1;
	    int builds = 0;
	    int[][] reach = new int[m][n];
	    int[][] dis = new int[m][n];
	    for (int i = 0; i < m; i++) {
	      for (int j = 0; j < n; j++) {
	        if (grid[i][j] == 1) {
	          builds++;
	          bfs(grid, i, j, reach, dis);
	        }
	      }
	    }
	    int result = Integer.MAX_VALUE;
	    for (int i = 0; i < m; i++) {
	      for (int j = 0; j < n; j++) {
	        if (grid[i][j] == 0 && reach[i][j] == builds) result = Math.min(result, dis[i][j]);
	      }
	    }
	    return result == Integer.MAX_VALUE ? -1 : result;
	  }

	  private void bfs(int[][] grid, int r, int c, int[][] reach, int[][] dis) {
	    int colSize = grid[0].length;
	    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	    Queue<int[]> q = new LinkedList<>();
	    Set<Integer> visited = new HashSet<>();
	    int level = 1;
	    for (int[] dir : dirs) {
	      int x = r + dir[0], y = c + dir[1];
	      if (x > -1 && x < grid.length && y > -1 && y < grid[0].length && grid[x][y] == 0) {
	        int[] pos = new int[]{x, y};
	        q.offer(pos);
	        visited.add(findIndex(pos, colSize));
	        reach[x][y]++;
	        dis[x][y] += level;
	      }
	    }
	    while (!q.isEmpty()) {
	      level++;
	      int size = q.size();
	      for (int i = 0; i < size; i++) {
	        int[] cur = q.poll();
	        for (int[] dir : dirs) {
	          int x = cur[0] + dir[0], y = cur[1] + dir[1];
	          if (x > -1 && x < grid.length && y > -1 && y < grid[0].length && grid[x][y] == 0
	              && visited.add(findIndex(new int[]{x, y}, colSize))) {
	            q.offer(new int[]{x, y});
	            reach[x][y]++;
	            dis[x][y] += level;
	          }
	        }
	      }
	    }
	  }

	  private int findIndex(int[] pos, int colSize) {
	    return pos[0] * colSize + pos[1];
	  }

	  public static void main(String[] args) {
	    Prob317 prob317 = new Prob317();
	    System.out.println(prob317.shortestDistance(new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}}));
	  }
}
