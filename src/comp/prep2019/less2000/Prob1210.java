package comp.prep2019.less2000;
import java.util.*;
public class Prob1210 {
	public int minimumMoves(int[][] grid) {
        int n = grid.length;
        if (grid[n - 1][n - 1] == 1 || grid[n -1][n - 2] == 1) return -1;
        //3rd element is for orientation
        // 0th indicates, snake is horizontal
        // 1st indicates, snake is in vertical orientation
        boolean[][][] visited = new boolean[n][n][2];
        // a snake position is represented by it's tail location and orientation
        // orientation 0 means horizontal and 1 means vertical
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 0});
        visited[0][0][0] = true;
        int result = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	result++;
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		List<int[]> nexts = findNextPositions(cur, grid);
        		for (int[] next : nexts) {
        			if (next[0] == n - 1 && next[1] == n - 2 && next[2] == 0) 
        				return result;
        			if (visited[next[0]][next[1]][next[2]]) continue;
        			visited[next[0]][next[1]][next[2]] = true;
        			q.offer(next);
        		}
        	}
        }
        return -1;
    }

	private List<int[]> findNextPositions(int[] cur, int[][] grid) {
		int n = grid.length;
		List<int[]> result = new ArrayList<>();
		if (cur[2] == 0) {
			if (cur[1] + 2 < n && grid[cur[0]][cur[1] + 2] == 0) 
				result.add(new int[] {cur[0], cur[1] + 1, cur[2]});
			if (cur[0] + 1 < n && grid[cur[0] + 1][cur[1]] == 0 
					&& grid[cur[0] + 1][cur[1] + 1] == 0) 
				result.add(new int[] {cur[0] + 1, cur[1], cur[2]});
			if (cur[0] + 1 < n && grid[cur[0] + 1][cur[1]] == 0 
					&& grid[cur[0] + 1][cur[1] + 1] == 0) {
				result.add(new int[] {cur[0], cur[1], 1});
			}
		} else {
			if (cur[1] + 1 < n && grid[cur[0]][cur[1] + 1] == 0 
					&& grid[cur[0] + 1][cur[1] + 1] == 0) 
				result.add(new int[] {cur[0], cur[1] + 1, cur[2]});
			if (cur[0] + 2 < n && grid[cur[0] + 2][cur[1]] == 0) 
				result.add(new int[] {cur[0] + 1, cur[1], cur[2]});
			if (cur[1] + 1 < n && grid[cur[0]][cur[1] + 1] == 0 
					&& grid[cur[0] + 1][cur[1] + 1] == 0) {
				result.add(new int[] {cur[0], cur[1], 0});
			}
		}
		return result;
	}
}
