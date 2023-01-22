package com.prep2020.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem529 {
	public char[][] updateBoard(char[][] board, int[] click) {
		if (board[click[0]][click[1]] == 'B') return board;
        if (board[click[0]][click[1]] == 'M') {
        	board[click[0]][click[1]] = 'X';
        	return board;
        }
        int mines = 0;
        int[][] dirs = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1},
        	{1, -1}, {1, 0}, {1, 1}};
        List<int[]> nexts = new ArrayList<>();
        for (int[] dir : dirs) {
        	int[] next = new int[] {click[0] + dir[0], click[1] + dir[1]};
        	if (next[0] > -1 &&  next[0] < board.length && next[1] > -1 
        			&& next[1] < board[0].length) {
        		if (board[next[0]][next[1]] == 'M') {
        			mines++;
        		} else if (board[next[0]][next[1]] == 'E') nexts.add(next);
        	}
        }
        if (mines > 0) board[click[0]][click[1]] = (char)(mines + '0');
        else {
        	board[click[0]][click[1]] = 'B';
        	for(int[] c : nexts) updateBoard(board, c);
        }
        return board;
    }
}
