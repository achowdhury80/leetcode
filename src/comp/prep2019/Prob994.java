package comp.prep2019;
import java.util.*;
public class Prob994 {
	public int orangesRotting(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) q.offer(new int[] {i, j});
        	}
        }
        int result = 0;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
        	int size = q.size();
        	boolean changed = false;
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		for (int[] dir : dirs) {
        			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        			if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n 
        					|| grid[next[0]][next[1]] != 2) continue;
        			changed = true;
        			break;
        		}
        	}
        	if (!changed) break;
        	result++;
        }
        return result;
    }
}
