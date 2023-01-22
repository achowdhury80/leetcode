package com.prep2020.hard;
import java.util.*;
public class Problem2290 {
	public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		dist[i][j] = Integer.MAX_VALUE;
        	}
        }
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        pq.offer(new int[] {0, 0, 0});
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (cur[2] >= dist[cur[0]][cur[1]]) continue;
        	dist[cur[0]][cur[1]] = cur[2];
        	if (cur[0] == m - 1 && cur[1] == n - 1) return cur[2];
        	for (int[] dir : dirs) {
        		int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1], cur[2]};
        		if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n) continue;
        		next[2] += grid[next[0]][next[1]];
        		pq.offer(next);
        	}
        }
        return dist[m - 1][n - 1];
    }
}
