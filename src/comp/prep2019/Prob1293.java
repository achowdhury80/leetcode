package comp.prep2019;
import java.util.*;
public class Prob1293 {
	public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) return 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		visited[i][j] = Integer.MAX_VALUE;
        	}
        }
        q.offer(new int[] {0, 0, k});
        visited[0][0] = 0;
        int result = 0;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		for (int[] dir : dirs) {
        			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1], cur[2]};
        			if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n) continue;
        			if (next[0] == m - 1 && next[1] == n - 1) return result;
        			next[2] -= grid[next[0]][next[1]];
        			if (next[2] < 0) continue;
        			if (visited[next[0]][next[1]] == Integer.MAX_VALUE || next[2] > visited[next[0]][next[1]]) {
        				q.offer(next);
        				visited[next[0]][next[1]] = next[2];
        			} 
        		}
        	}
        }
        return -1;
    }
}
