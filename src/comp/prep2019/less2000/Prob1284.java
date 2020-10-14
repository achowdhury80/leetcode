package comp.prep2019.less2000;
import java.util.*;
public class Prob1284 {
	public int minFlips(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int state = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (mat[i][j] == 1) {
        			int pos = i * n + j;
        			state |= 1 << pos;
        		}
        	}
        }
        if (state == 0) return 0;
        boolean[] visited = new boolean[1 << (m * n)];
        Queue<Integer> q = new LinkedList<>();
        q.offer(state);
        visited[state] = true;
        int result = 0;
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		Set<Integer> nextStates = findNextState(cur, m, n);
        		for (int nextState : nextStates) {
        			if (nextState == 0) return result;
        			if (!visited[nextState]) {
        				visited[nextState] = true;
        				q.offer(nextState);
        			}
        		}
        	}
        }
        return -1; 
    }
	
	private Set<Integer> findNextState(int state, int m, int n) {
		Set<Integer> result = new HashSet<>();
		int[][] dirs = new int[][] {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for (int i = 0; i < m * n; i++) {
			int[] curPos = new int[] {i / n, i % n};
			List<int[]> flipPos = new ArrayList<>();
			for (int[] dir : dirs) {
				int[] pos = new int[] {curPos[0] + dir[0], curPos[1] + dir[1]};
				if (pos[0] > - 1 && pos[0] < m && pos[1] > -1 && pos[1] < n) 
					flipPos.add(pos);
			}
			int newState = state;
			for (int[] pos : flipPos) {
				int idx = pos[0] * n + pos[1];
				newState ^= (1 << idx);
			}
			result.add(newState);
		}
		return result;
	}
}
