package com.prep2020.medium;

public class Problem1559 {
	public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] color = new int[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (color[i][j] != 2 && cycleExists(new int[] {i, j}, 
        				new int[] {-1, -1}, color, grid)) return true;
        	}
        }
        return false;
    }
	
	private boolean cycleExists(int[] cur, int[] parent, int[][] color, 
			char[][] grid) {
		if (color[cur[0]][cur[1]] == 1) return true;
		if (color[cur[0]][cur[1]] == 2) return false;
		color[cur[0]][cur[1]] = 1;
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for (int[] dir : dirs) {
			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
			if (next[0] < 0 || next[1] < 0 || next[0] == grid.length 
					|| next[1] == grid[0].length) continue;
			if (next[0] == parent[0] && next[1] == parent[1] 
					|| grid[cur[0]][cur[1]] != grid[next[0]][next[1]]) 
				continue;
			if (cycleExists(next, cur, color, grid)) return true;
		}
		color[cur[0]][cur[1]] = 2;
		return false;
	}
	
	public static void main(String[] args) {
		Problem1559 problem = new Problem1559();
		/*System.out.println(problem.containsCycle(new char[][] {{'b'}, 
			{'b'}}));*/
		System.out.println(problem.containsCycle(new char[][] {
			{'f','a','a','c','b'},{'e','a','a','e','c'},{'c','f','b','b','b'},
			{'c','e','a','b','e'},{'f','e','f','b','f'}}));
	}
}
