package com.leet.algo;

public class Prob999 {
	public int numRookCaptures(char[][] board) {
        int r = -1, c = -1;
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == 'R') {
        			r = i;
        			c = j;
        			break;
        		}
        	}
        }
        
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = 0;
        for (int[] dir : dirs) {
        	int[] curPos = new int[] {r, c};
        	while (true) {
        		curPos = new int[] {curPos[0] + dir[0], curPos[1] + dir[1]};
        		if (curPos[0] < 0 || curPos[0] > 7 || curPos[1] < 0 || curPos[1] > 7 || board[curPos[0]][curPos[1]] == 'B') break;
        		else if (board[curPos[0]][curPos[1]] == 'p') {
        			result++;
        			break;
        		}
        	}
        }
        return result;
    }
}
