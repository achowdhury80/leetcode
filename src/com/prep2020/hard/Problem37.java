package com.prep2020.hard;

public class Problem37 {
	public void solveSudoku(char[][] board) {
		solve(board);
	}

	private boolean canPlace(char[][] board, int[] pos, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[i][pos[1]] == c || board[pos[0]][i] == c)
				return false;
		}
		int[] boxStart = new int[] { (pos[0] / 3) * 3, (pos[1] / 3) * 3 };
		for (int i = boxStart[0]; i < boxStart[0] + 3; i++) {
			for (int j = boxStart[1]; j < boxStart[1] + 3; j++) {
				if (board[i][j] == c)
					return false;
			}
		}
		return true;
	}

	public boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (canPlace(board, new int[] { i, j }, c)) {
							board[i][j] = c;
							if (solve(board))
								return true;
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}
}
