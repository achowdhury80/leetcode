package comp.prep2019.less1000;

import java.util.PriorityQueue;
import java.util.Queue;

public class Prob407 {
	public int trapRainWater(int[][] heightMap) {
        Queue<int[]> q = new PriorityQueue<>((x, y) -> heightMap[x[0]][x[1]] 
        		- heightMap[y[0]][y[1]]);
        int m = heightMap.length, n = heightMap[0].length, result = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
        	q.offer(new int[] {i, 0});
        	visited[i][0] = true;
        	q.offer(new int[] {i, n - 1});
        	visited[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
        	q.offer(new int[] {0, i});
        	visited[0][i] = true;
        	q.offer(new int[] {m - 1, i});
        	visited[m - 1][i] = true;
        }
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	for (int[] dir : dirs) {
        		int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        		if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n 
        				|| visited[next[0]][next[1]]) continue;
        		visited[next[0]][next[1]] = true;
        		q.offer(next);
        		if (heightMap[next[0]][next[1]] < heightMap[cur[0]][cur[1]]) {
        			result += heightMap[cur[0]][cur[1]] - heightMap[next[0]][next[1]];
        			heightMap[next[0]][next[1]] = heightMap[cur[0]][cur[1]];
        		}
        	}
        }
        return result;
    }
}
