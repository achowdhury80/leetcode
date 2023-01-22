package com.prep2020.hard;
import java.util.*;
public class Problem317 {
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
	          bfs(grid, new int[] {i, j}, reach, dis);
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

	private void bfs(int[][] grid, int[] pos, int[][] reach, int[][] dis) {
		int m = dis.length, n = dis[0].length;
		Queue<int[]> q = new LinkedList<>();
		q.offer(pos);
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		boolean[][] visited = new boolean[m][n];
		int level = 0;
		while(!q.isEmpty()) {
			level++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for (int[] dir : dirs) {
					int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
					if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n 
							|| grid[next[0]][next[1]] != 0 || visited[next[0]][next[1]]) continue;
					dis[next[0]][next[1]] += level;
					visited[next[0]][next[1]] = true;
					q.offer(next);
					reach[next[0]][next[1]]++;
				}
			}
		}
		
	}
}
