package comp.prep2019.less2000;
import java.util.*;
public class Prob1263 {
	public int minPushBox(char[][] grid) {
        Queue<int[][]> q = new LinkedList<>();
        int[] pPos = null, bPos = null, tPos = null;
        int m = grid.length, n = grid[0].length;
        int found = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 'B') {
        			bPos = new int[] {i, j};
        			found++;
        			grid[i][j] = '.';
        		} else if (grid[i][j] == 'S') {
        			pPos = new int[] {i, j};
        			found++;
        			grid[i][j] = '.';
        		} else if (grid[i][j] == 'T') {
        			tPos = new int[] {i, j};
        			found++;
        			grid[i][j] = '.';
        		}
        		if (found == 3) break;
        	}
        	if (found == 3) break;
        }
        int[][] cur = new int[][] {pPos, bPos};
        q.offer(cur);
        int result = 0;
        Set<String> visited = new HashSet<>();
        visited.add(findKeyForVisited(cur, n));
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		cur = q.poll();
        		for (int j = 0; j < dirs.length; j++) {
        			int[] next = new int[] {cur[1][0] + dirs[j][0], cur[1][1] + dirs[j][1]};
        			int k = j % 2 == 0 ? (j + 1) : (j - 1);
        			int[] prev = new int[] {cur[1][0] + dirs[k][0], cur[1][1] + dirs[k][1]};
        			if (next[0] < 0 || prev[0] < 0 || next[0] == m || prev[0] == m || next[1] < 0
        					|| prev[1] < 0 || next[1] == n || prev[1] == n 
        					|| grid[next[0]][next[1]] != '.' || grid[prev[0]][prev[1]] != '.') continue;
        			int[][] candidate = new int[][] {cur[1], next};
        			String key = findKeyForVisited(candidate, n);
        			if (visited.contains(key)) continue;
        			grid[cur[1][0]][cur[1][1]] = 'B'; 
        			boolean reachable = canReach(grid, cur[0], prev);
        			grid[cur[1][0]][cur[1][1]] = '.'; 
        			if (!reachable) continue;
        			if (next[0] == tPos[0] && next[1] == tPos[1]) return result;
        			q.offer(candidate);
        			visited.add(key);
        		}
        	}
        }
        return -1;
    }
	private String findKeyForVisited(int[][] cur, int n) {
		return (cur[0][0] * n + cur[0][1]) + "#" +  (cur[1][0] * n + cur[1][1]);
	}
	
	private boolean canReach(char[][] grid, int[] s, int[] target) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(s);
		int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		visited[s[0]][s[1]] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == target[0] && cur[1] == target[1]) return true;
			for (int[] dir : dirs) {
				int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
				if (next[0] < 0 || next[0] == grid.length || next[1] < 0 
						|| next[1] == grid[0].length || visited[next[0]][next[1]] 
								|| grid[next[0]][next[1]] != '.') continue;
				visited[next[0]][next[1]] = true;
				q.offer(next);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Prob1263 prob = new Prob1263();
		System.out.println(prob.minPushBox(new char[][] {
			{'#','#','#','#','#','#'},
			{'#','T','#','#','#','#'},
			{'#','.','.','B','.','#'},
			{'#','.','#','#','.','#'},
			{'#','.','.','.','S','#'},
			{'#','#','#','#','#','#'}}));
	}
}
