package comp.prep2019.less1000;
import java.util.*;
public class Prob778 {
	public int swimInWater(int[][] grid) {
		int n = grid.length;
        int result = 0;
        result = grid[0][0];
        Queue<int[]> pq = new PriorityQueue<>(
        		(x, y) -> grid[x[0]][x[1]] - grid[y[0]][y[1]]);
        pq.offer(new int[] {0, 0});
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	result = grid[cur[0]][cur[1]];
        	if (cur[0] == n - 1 && cur[1] == n - 1) return result;
        	Queue<int[]> q = new LinkedList<>();
        	q.offer(cur);
        	grid[cur[0]][cur[1]] = -1;
        	while(!q.isEmpty()) {
        		int[] arr = q.poll();
        		for (int[] dir : dirs) {
        			int[] next = new int[] {arr[0] + dir[0], arr[1] + dir[1]};
        			if (next[0] < 0 || next[0] >= n || next[1] < 0 
        					|| next[1] >= n || grid[next[0]][next[1]] == -1) continue;
        			if (grid[next[0]][next[1]] > result) pq.offer(next); 
        			else {
	        			if (next[0] == n - 1 && next[1] == n - 1) return result;
	        			grid[next[0]][next[1]] = -1;
	        			q.offer(next);
        			}
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob778 prob = new Prob778();
		System.out.println(prob.swimInWater(new int[][] {{0, 2},{1, 3},}));
	}
}
