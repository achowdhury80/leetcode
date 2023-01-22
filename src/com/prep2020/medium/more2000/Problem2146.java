package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2146 {
	public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, 
			int[] start, int k) {
		int m = grid.length, n = grid[0].length;
		List<List<Integer>> result = new ArrayList<>();
		Queue<int[]> pq = new PriorityQueue<>((x, y) -> (Math.abs(grid[x[0]][x[1]]) 
				== Math.abs(grid[y[0]][y[1]])) ? ((x[0] == y[0]) ? (x[1] - y[1]) 
						: (x[0] - y[0])) : (Math.abs(grid[x[0]][x[1]]) 
								- Math.abs(grid[y[0]][y[1]])));
		pq.offer(start);
		grid[start[0]][start[1]] = -grid[start[0]][start[1]];
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while(!pq.isEmpty() && k > 0) {
			int size = pq.size();
			Queue<int[]> q = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				int[] cur = pq.poll();
				if (Math.abs(grid[cur[0]][cur[1]]) >= pricing[0] 
						&& Math.abs(grid[cur[0]][cur[1]]) <= pricing[1]) {
					result.add(Arrays.asList(cur[0], cur[1]));
					k--;
					if (k == 0) break;
				}
				for (int[] dir : dirs) {
					int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
					if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n 
							|| grid[next[0]][next[1]] < 1) continue;
					grid[next[0]][next[1]] = -grid[next[0]][next[1]];
					q.offer(next);
				}
			}
			if (k == 0) break;
			while(!q.isEmpty()) pq.offer(q.poll());
		}
        return result;
    }
}
