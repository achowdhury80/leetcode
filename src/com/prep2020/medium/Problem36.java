package com.prep2020.medium;
import java.util.*;
public class Problem36 {
	/**
	 * O(1)
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) 
        	if (!isValid(board, i, true) || !isValid(board, i, false)) return false;
        for (int i = 0; i < 9; i += 3) 
        	for (int j = 0; j < 9; j += 3)
        		if (!isValidBox(board, i, j)) return false;
        return true;
    }
	
	private boolean isValid(char[][] board, int index, boolean row) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			char c = row ? board[index][i] : board[i][index];
			if (c != '.') {
				if (set.contains(c)) return false;
				set.add(c);
			}
		}
		return true;
	}
	
	private boolean isValidBox(char[][] board, int row, int col) {
		Set<Character> set = new HashSet<>();
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				char c = board[i][j];
				if (c != '.') {
					if (set.contains(c)) return false;
					set.add(c);
				}
			}
		}
		return true;
	}
}
