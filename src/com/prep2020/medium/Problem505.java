package com.prep2020.medium;
import java.util.*;
public class Problem505 {
	public int shortestDistance(int[][] maze, int[] start, 
			int[] destination) {
		int m = maze.length, n = maze[0].length;
		Queue<int[]> q = new PriorityQueue<>((x, y) -> x[2] - y[2]);
		int[][] distance = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		q.offer(new int[] {start[0], start[1], 0});
		distance[start[0]][start[1]] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			List<int[]> nexts = findNexts(maze, cur);
			for (int[] next : nexts) {
				if (maze[next[0]][next[1]] == 1 
						|| distance[next[0]][next[1]] <= next[2]) 
					continue;
				distance[next[0]][next[1]] = next[2];
				q.offer(next);
			}
		}
		return distance[destination[0]][destination[1]] == Integer.MAX_VALUE 
				? -1 : distance[destination[0]][destination[1]];
	}

	private List<int[]> findNexts(int[][] maze, int[] start) {
		int m = maze.length, n = maze[0].length;
		List<int[]> result = new ArrayList<>();
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for (int[] dir : dirs) {
			int[] cur = new int[] {start[0], start[1], start[2]};
			while(true) {
				int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1], 
						cur[2] + 1};
				if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n 
						|| maze[next[0]][next[1]] == 1) break;
				cur = next;
			}
			if (cur[0] != start[0] || cur[1] != start[1]) result.add(cur);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem505 problem = new Problem505();
		System.out.println(problem.shortestDistance(new int[][]{{0,0,1,0,0},
			{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}, 
				new int[] {0,4}, new int[]{3,2}));
	}
}
