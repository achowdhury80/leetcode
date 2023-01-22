package com.prep2020.hard;

public class Problem52 {
	/**
	 * Time complexity: O(N!)O(N!), where NN is the number of queens (which is the same as the width and height of the board).

Unlike the brute force approach, we place a queen only on squares that aren't attacked. For the first queen, we have NN options. For the next queen, we won't attempt to place it in the same column as the first queen, and there must be at least one square attacked diagonally by the first queen as well. Thus, the maximum number of squares we can consider for the second queen is N - 2N−2. For the third queen, we won't attempt to place it in 2 columns already occupied by the first 2 queens, and there must be at least two squares attacked diagonally from the first 2 queens. Thus, the maximum number of squares we can consider for the third queen is N - 4N−4. This pattern continues, giving an approximate time complexity of N!N! at the end.

Space complexity: O(N)O(N), where NN is the number of queens (which is the same as the width and height of the board).

Extra memory used includes the 3 sets used to store board state, as well as the recursion call stack. All of this scales linearly with the number of queens.
	 * @param n
	 * @return
	 */
	public int totalNQueens(int n) {
       boolean[][] grid = new boolean[n][n];
       return helper(grid, 0);
    }
	
	private int helper(boolean[][] grid, int row) {
		if (row == grid.length) return 1;
		int result = 0;
		for (int j = 0; j < grid.length; j++) {
			if (canPlace(grid, new int[] {row, j})) {
				grid[row][j] = true;
				result += helper(grid, row + 1);
				grid[row][j] = false;
			}
		}
		return result;
	}
	
	private boolean canPlace(boolean[][] grid, int[] pos) {
		for (int i = 1; pos[0] - i > -1; i++) {
			if (grid[pos[0] - i][pos[1]]) return false;
			if (pos[1] + i < grid[1].length && grid[pos[0] - i][pos[1] + i]) return false;
			if (pos[1] - i > -1 && grid[pos[0] - i][pos[1] - i]) return false;
		}
		return  true;
	}
}
