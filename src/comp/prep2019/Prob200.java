package comp.prep2019;
import java.util.*;
public class Prob200 {
	public int numIslands(char[][] grid) {
        int m, n;
        if(grid == null || (m = grid.length) < 1 || (n = grid[0].length) < 1) 
        	return 0;
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == '1') {
        			result++;
        			populate(grid, new int[] {i, j});
        		}
        	}
        }
        return result;
    }
	
	private void populate(char[][] grid, int[] cur) {
		int m = grid.length, n = grid[0].length;
		int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		Queue<int[]> q = new LinkedList<>();
		q.offer(cur);
		grid[cur[0]][cur[1]] = '2';
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			
			for (int[] dir : dirs) {
				int[] next = new int[] {pos[0] + dir[0], pos[1] + dir[1]};
				if (next[0] > -1 && next[0] < m && next[1] > -1 && next[1] < n
						&& grid[next[0]][next[1]] == '1') {
					q.offer(next);
					grid[next[0]][next[1]] = '2';
				}
			}
		}
	}
}
