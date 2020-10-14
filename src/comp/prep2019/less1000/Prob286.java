package comp.prep2019.less1000;
import java.util.*;
public class Prob286 {
	public void wallsAndGates(int[][] rooms) {
		int m, n;
        if (rooms == null || (m = rooms.length) == 0 
        		|| (n = rooms[0].length) == 0) return;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (rooms[i][j] == 0) {
        			q.offer(new int[] {i, j});
        		}
        	}
        }
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int dis = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	dis++;
        	for (int i = 0; i < size; i++) {
	        	int[] cur = q.poll();
	        	for (int[] dir : dirs) {
	        		int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
	        		if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n
	        				|| rooms[next[0]][next[1]] != Integer.MAX_VALUE) continue;
	        		rooms[next[0]][next[1]] = dis;
	        		q.offer(next);
	        	}
        	}
        }
    }
}
