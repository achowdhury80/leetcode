package com.prep2020.hard;
import java.util.*;
public class Problem1293 {
	public int shortestPath(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		// int[] - 0th element x, 1st element y, 2nd element number of obstacles removed, 3rd element number of steps
		Queue<int[]> pq = new PriorityQueue<>((x, y) -> (x[3] == y[3]) ? (x[2] - y[2]) : (x[3] - y[3]));
		pq.offer(new int[] {0, 0, 0, 0});
		int[][][] dis = new int[m][n][k + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int x = 0; x <= k; x++) dis[i][j][x] = Integer.MAX_VALUE;
			}
		}
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (dis[cur[0]][cur[1]][cur[2]] <= cur[3]) continue;
			dis[cur[0]][cur[1]][cur[2]] = cur[3];
			if (cur[0] == m - 1 && cur[1] == n - 1) return cur[3];
			for (int[] dir : dirs) {
				int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1], cur[2], cur[3] + 1};
				if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n) continue;
				if (grid[next[0]][next[1]] == 1) next[2]++;
				if (next[2] > k) continue;
				pq.offer(next);
			}
		}
        return -1;
    }
}
