package com.prep2020.medium;
public class Problem1958 {
	public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        if (board[rMove][cMove] != '.')  return false;
        int[] start = new int[] {rMove, cMove};
        return isValid(board, start, color, new int[] {0, -1})
        		|| isValid(board, start, color, new int[] {0, 1})
        		|| isValid(board, start, color, new int[] {-1, 0})
        		|| isValid(board, start, color, new int[] {1, 0})
        		|| isValid(board, start, color, new int[] {-1, 1})
        		|| isValid(board, start, color, new int[] {1, -1})
        		|| isValid(board, start, color, new int[] {-1, -1})
        		|| isValid(board, start, color, new int[] {1, 1});
        		
    }
	
	private boolean isValid(char[][] board, int[] start, char color, int[] dir) {
		boolean oppositeFound = false;
		int[] cur = start;
		int m = board.length, n= board[0].length;
		while(true) {
			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
			if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n 
					|| board[next[0]][next[1]] == '.') return false;
			if (board[next[0]][next[1]] != color) oppositeFound = true;
			else return oppositeFound;
			cur = next;
		}
	}
}
