package comp.prep2019;
import java.util.*;
public class Prob1197 {
	public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) return 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        int result = 0;
        int[] dst = new int[] {x, y};
        Set<String> visited = new HashSet<>();
        visited.add(0 + ":" + 0);
        int[][] dirs = new int[][] {{2, -1}, {2, 1}, {-2, -1}, {-2, 1}, {1, -2}, 
        	{-1, -2}, {1, 2}, {-1, 2}};
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		for (int[] dir : dirs) {
        			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        			if (next[0] == x && next[1] == y) return result;
        			String key = next[0] + ":" + next[1];
        			if (visited.contains(key)) continue;
        			visited.add(key);
        			int curDis = findDis(cur, dst);
        			if (curDis < 3) {
        				q.offer(next);
        			} else {
        				int newDis = findDis(next, dst);
        				if (newDis <= curDis) q.offer(next);
        			}
        		}
        		
        	}
        }
        return result;
    }
	
	private int findDis(int[] x, int[] y) {
		return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
	}
}
