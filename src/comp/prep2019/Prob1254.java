package comp.prep2019;
import java.util.*;
public class Prob1254 {
	/**
	 * O(MN) time
	 * @param grid
	 * @return
	 */
	public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 1; i < m - 1; i++) {
        	for (int j = 1; j < n - 1; j++) {
        		if (grid[i][j] == 0 && helper(grid, new int[] {i, j})) result++;
        	}
        }
        return result;
    }
	
	private boolean helper(int[][] grid, int[] start) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		grid[start[0]][start[1]] = -1;
		int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		boolean result = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int[] dir : dirs) {
				int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
				if (grid[next[0]][next[1]] != 0) continue;
				if (next[0] == 0 || next[0] == grid.length - 1 || next[1] == 0 
						|| next[1] == grid[0].length - 1) {
					result = false;
				} else {
					grid[next[0]][next[1]] = -1;
					q.offer(next);
				}
			}
		}
		return result;
	}
}
