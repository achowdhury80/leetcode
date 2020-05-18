package comp.prep2019;
import java.util.*;
public class Prob1368 {
	public int minCost(int[][] grid) {
		int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        boolean[][] visited =  new boolean[m][n];
        pq.offer(new int[] {0, 0, 0});
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (cur[0] == m - 1 && cur[1] == n - 1) return cur[2];
        	visited[cur[0]][cur[1]] = true;
        	for (int i = 0; i < dirs.length; i++) {
        		int[] next = new int[] {cur[0] + dirs[i][0], cur[1] + dirs[i][1],
        				i + 1 == grid[cur[0]][cur[1]] ? cur[2] : cur[2] + 1};
        		if (next[0] > -1 && next[0] < m && next[1] > -1 && next[1] < n 
        				&& !visited[next[0]][next[1]]) {
        			pq.offer(next);
        		}
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Prob1368 prob = new Prob1368();
		System.out.println(prob.minCost(new int[][] {{1, 1, 3}, {3, 2, 2}, {1, 1, 4}}));
	}
}
