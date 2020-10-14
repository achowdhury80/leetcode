package comp.prep2019.less1000;
import java.util.*;
public class Prob827 {
	public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> size = new HashMap<>();
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		int idx = n * i + j;
        		if (visited[idx] || grid[i][j] == 0) continue;
        		q.offer(new int[] {i, j});
        		visited[idx] = true;
        		parent.put(idx, idx);
        		size.put(idx, 1);
        		result = Math.max(result, 1);
        		while(!q.isEmpty()) {
        			int[] cur = q.poll();
        			for (int[] dir : dirs) {
        				int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        				if (next[0] < 0 || next[0] == m || next[1] < 0 
        						|| next[1] == n || grid[next[0]][next[1]] == 0) 
        					continue;
        				idx = n * next[0] + next[1];
        				if (visited[idx]) continue;
        				visited[idx] = true;
        				q.offer(next);
        				int parentIdx = parent.get(cur[0] * n + cur[1]);
        				parent.put(idx, parentIdx);
        				size.put(parentIdx, size.get(parentIdx) + 1);
        				result = Math.max(result, size.get(parentIdx));
        			}
        		}
        		
        	}
        }
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 0) {
        			Set<Integer> parentSet = new HashSet<>();
        			for (int[] dir : dirs) {
        				int[] next = new int[] {i + dir[0], j + dir[1]};
        				if (next[0] < 0 || next[0] == m || next[1] < 0 
        						|| next[1] == n || grid[next[0]][next[1]] == 0) 
        					continue;
        				parentSet.add(parent.get(next[0] * n + next[1]));
        			}
        			int newSize = 1;
        			for (int p : parentSet) newSize += size.get(p);
        			result = Math.max(result, newSize);
        		}
        	}
        }
        return result;
    }
}
