package com.prep2020.medium;

public class Problem289 {
	/**
	 * O(N)
	 * @param board
	 */
	public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		int neighbors = findNeighbors(board, new int[] {i, j});
        		if (neighbors == 3 || board[i][j] == 1 && neighbors == 2) board[i][j] |= 2;
        	}
        }
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		board[i][j] >>= 1;
        	}
        }
    }

	private int findNeighbors(int[][] board, int[] cur) {
		int m = board.length, n = board[0].length;
		int neighbors = 0;
		for (int i = Math.max(0, cur[0] - 1); i < Math.min(m, cur[0] + 2); i++) {
			for (int j = Math.max(0,  cur[1] - 1); j < Math.min(n, cur[1] + 2); j++) {
				if (i == cur[0] && j == cur[1]) continue;
				if ((board[i][j] & 1) == 1) neighbors++;
			}
		}
		return neighbors;
	}
}
