package com.prep2020.easy;

public class Problem999 {
	public int numRookCaptures(char[][] board) {
        int m = board.length, n = board[0].length;
        int[] pos = null;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (board[i][j] == 'R') {
        			pos = new int[] {i, j};
        		}
        	}
        }
        int result = 0;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
        	result += findPawnCount(board, pos, dir);
        }
        return result;
    }

	private int findPawnCount(char[][] board, int[] pos, int[] dir) {
		while(true) {
			pos = new int[] {pos[0] + dir[0], pos[1] + dir[1]};
			if (pos[0] < 0 || pos[0] == board.length || pos[1] < 0 || pos[1] == board[0].length
					|| board[pos[0]][pos[1]] == 'B') return 0;
			if (board[pos[0]][pos[1]] == 'p') return 1;
		}
	}
}
