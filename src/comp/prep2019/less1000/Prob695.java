package comp.prep2019.less1000;

import java.util.LinkedList;
import java.util.Queue;

public class Prob695 {
	/**
	 * O(N)
	 * @param grid
	 * @return
	 */
	public int maxAreaOfIsland(int[][] grid) {
		int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			result = Math.max(result, helper(grid, new int[] {i, j}));
        		}
        	}
        }
        return result;
    }
	
	private int helper(int[][] grid, int[] start) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		grid[start[0]][start[1]] = -1;
		int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int result = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int[] dir : dirs) {
				int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
				if (next[0] < 0 || next[0] == grid.length || next[1] < 0 
						|| next[1] == grid[0].length || grid[next[0]][next[1]] != 1) continue;
				grid[next[0]][next[1]] = -1;
				q.offer(next);
				result++;
			}
		}
		return result;
	}
}
