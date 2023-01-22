package com.prep2020.hard;
import java.util.*;
public class Problem778 {
	public int swimInWater(int[][] grid) {
		int n = grid.length;
		Queue<int[]> pq = new PriorityQueue<>((x, y) -> grid[x[0]][x[1]] - grid[y[0]][y[1]]);
		pq.offer(new int[] {0, 0});
		boolean[][] visited = new boolean[n][n];
		for (int t = 0; t < n * n; t++) {
			int[] peek = pq.peek();
			while(grid[peek[0]][peek[1]] <= t) {
				int[] cur = pq.poll();
				if (cur[0] == n - 1 && cur[1] == n - 1) return t;
				visited[cur[0]][cur[1]] = true;
				populate(pq, cur, t, grid, visited);
				if (visited[n - 1][n - 1]) return t;
				peek = pq.peek();
			}
		}
		return -1;
	}

	private void populate(Queue<int[]> pq, int[] cur, int t, int[][] grid, boolean[][] visited) {
		int n = grid.length;
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for (int[] dir : dirs) {
			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
			if (next[0] < 0 || next[0] == n || next[1] < 0 || next[1] == n || visited[next[0]][next[1]]) continue;
			if (grid[next[0]][next[1]] > t) {
				pq.offer(next);
				continue;
			}
			visited[next[0]][next[1]] = true;
			if (next[0] == n - 1 && next[1] == n - 1) return;
			populate(pq, next, t, grid, visited);
		}
	}
	
	public static void main(String[] args) {
		Problem778 problem = new Problem778();
		System.out.println(problem.swimInWater(new int[][] {{0, 2}, {1, 3}}));
	}
}
