package comp.prep2019;
import java.util.*;
public class Prob1030 {
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r0, c0});
        visited[r0][c0] = true;
        int idx = 0;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	result[idx++] = cur;
        	for (int[] dir : dirs) {
        		int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        		if (next[0] < 0 || next[0] == R || next[1] < 0 || next[1] == C
        				|| visited[next[0]][next[1]]) continue;
        		visited[next[0]][next[1]] = true;
        		q.offer(next);
        	}
        }
        return result;
    }
}
