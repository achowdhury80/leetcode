package comp.prep2019;
import java.util.*;
public class Prob286 {
	public void wallsAndGates(int[][] rooms) {
		int m, n;
        if (rooms == null || (m = rooms.length) == 0 
        		|| (n = rooms[0].length) == 0) return;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (rooms[i][j] == 0) {
        			populateDistance(rooms, i, j, m, n);
        		}
        	}
        }
    }
	
	private void populateDistance(int[][] rooms, int i, int j, int m, int n) {
		Queue<int[]> q = new LinkedList<>();
		int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int distance = 1;
		for (int[] dir : dirs) {
			int[] next = new int[] {i + dir[0], j + dir[1]};
			if (next[0] < m && next[0] > -1 && next[1] < n && next[1] > -1 
					&& rooms[next[0]][next[1]] > 0) {
				rooms[next[0]][next[1]] = distance;
				q.offer(next);
			}
		}
		while(!q.isEmpty()) {
			distance++;
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int[] cur = q.poll();
				for (int[] dir : dirs) {
					int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
					if (next[0] < m && next[0] > -1 && next[1] < n && next[1] > -1 
							&& rooms[next[0]][next[1]] > distance) {
						rooms[next[0]][next[1]] = distance;
						q.offer(next);
					}
				}
			}
			
		}
	}
}
