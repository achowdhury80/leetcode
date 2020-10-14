package comp.prep2019;

public class Prob1219 {
	/**
	 * O(4^n) time and O(N) space
	 * @param grid
	 * @return
	 */
	public int getMaximumGold(int[][] grid) {
		int result = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] != 0) {
        			boolean[][] visited = new boolean[grid.length][grid[0].length];
        			result = Math.max(result, dfs(grid, new int[] {i, j}, visited));
        		}
        	}
        }
        return result;
    }
	
	private int dfs(int[][] grid, int[] start, boolean[][] visited) {
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		int sum = grid[start[0]][start[1]];
		visited[start[0]][start[1]] = true;
		for (int[] dir : dirs) {
			int[] next = new int[] {start[0] + dir[0], start[1] + dir[1]};
			if (next[0] > -1 && next[0] < grid.length && next[1] > -1 && next[1] < grid[0].length && !visited[next[0]][next[1]] 
					&& grid[next[0]][next[1]] != 0) {
				int nextVal = dfs(grid, next, visited);
				sum = Math.max(sum, grid[start[0]][start[1]] + nextVal);
			}
		}
		visited[start[0]][start[1]] = false;
		return sum;
	}
}
