package comp.prep2019;
import java.util.*;
public class Prob1020 {
	public int numEnclaves(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < n; i++) {
        	if (A[0][i] == 1) {
        		bfs(A, new int[] {0, i});
        	}
        	if (A[m - 1][i] == 1) {
        		bfs(A, new int[] {m - 1, i});
        	}
        }
        for (int i = 0; i < m; i++) {
        	if (A[i][0] == 1) {
        		bfs(A, new int[] {i, 0});
        	}
        	if(A[i][n - 1] == 1) {
        		bfs(A, new int[] {i, n - 1});
        	}
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (A[i][j] == 1) result++;
        	}
        }
        return result;
    }
	
	public void bfs(int[][] A, int[] cur) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(cur);
		A[cur[0]][cur[1]] = 0;
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		while(!q.isEmpty()) {
			cur = q.poll();
			for (int[] dir : dirs) {
				int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
				if (next[0] > -1 && next[0] < A.length && next[1] > -1 
						&& next[1] < A[0].length && A[next[0]][next[1]] == 1) {
					q.offer(next);
					A[next[0]][next[1]] = 0;
				}
			}
		}
	}
}
