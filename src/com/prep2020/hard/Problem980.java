package com.prep2020.hard;

public class Problem980 {
	/**
	et NN be the total number of cells in the input grid.

	Time Complexity: \mathcal{O}(3^N)O(3 
	N
	 )

	Although technically we have 4 directions to explore at each step, we have at most 3 directions to try at any moment except the first step. The last direction is the direction where we came from, therefore we don't need to explore it, since we have been there before.

	In the worst case where none of the cells is an obstacle, we have to explore each cell. Hence, the time complexity of the algorithm is \mathcal{O}(4 * 3 ^{(N-1)}) = \mathcal{O}(3^N)O(4∗3 
	(N−1)
	 )=O(3 
	N
	 ).

	Space Complexity: \mathcal{O}(N)O(N)

	Thanks to the in-place technique, we did not use any additional memory to keep track of the state.

	On the other hand, we apply recursion in the algorithm, which could incur \mathcal{O}(N)O(N) space in the function call stack.

	Hence, the overall space complexity of the algorithm is \mathcal{O}(N)O(N). */
	public int uniquePathsIII(int[][] grid) {
		int m = grid.length, n = grid[0].length, nonObs = 0;
		int[] start = null;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					start = new int[] {i, j};
				} else if (grid[i][j] == 0) nonObs++;
			}
		}
        return helper(grid, start, new boolean[m][n], nonObs);
    }
	
	private int helper(int[][] grid, int[] start, boolean[][] visited, int nonObs) {
		visited[start[0]][start[1]] = true;
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		int result = 0;
		for (int[] dir : dirs) {
			int[] next = new int[] {start[0] + dir[0], start[1] + dir[1]};
			if (next[0] < 0 || next[0] == grid.length || next[1] < 0 
					|| next[1] == grid[0].length 
					|| visited[next[0]][next[1]] ||
					grid[next[0]][next[1]] == -1) continue;
			if (grid[next[0]][next[1]] == 2) {
				if (nonObs == 0) result++;
			} else {
				result += helper(grid, next, visited, nonObs - 1);
			}
		}
		visited[start[0]][start[1]] = false;
		return result;
	}
}
