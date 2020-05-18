package comp.prep2019;
import java.util.*;
public class Prob417 {
	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int m, n;
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || (m = matrix.length) < 1 || (n = matrix[0].length) < 1) 
        	return result;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) populate(matrix, pacific, new int[] {i, 0});
        for (int i = 1; i < n; i++) populate(matrix, pacific, new int[] {0, i});
        for (int i = 0; i < m; i++) populate(matrix, atlantic, new int[] {i, n - 1});
        for (int i = 0; i < n - 1; i++) populate(matrix, atlantic, new int[] {m - 1, i});
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (pacific[i][j] && atlantic[i][j]) {
        			List<Integer> list = new ArrayList<>();
        			list.add(i);
        			list.add(j);
        			result.add(list);
        		}
        	}
        }
        return result;
        
    }
	
	private void populate(int[][] matrix, boolean[][] grid, int[] cur) {
		int m = matrix.length, n = matrix[0].length;
		Queue<int[]> q = new LinkedList<>();
		q.offer(cur);
		grid[cur[0]][cur[1]] = true;
		int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			for (int[] dir : dirs) {
				int[] next = new int[] {pos[0] + dir[0], pos[1] + dir[1]};
				if (next[0] > -1 && next[0] < m && next[1] > -1 && next[1] < n 
						&& !grid[next[0]][next[1]] 
						&& matrix[pos[0]][pos[1]] <= matrix[next[0]][next[1]]) {
					q.offer(next);
					grid[next[0]][next[1]] = true;
				}
			}
			
		}
	}
}
