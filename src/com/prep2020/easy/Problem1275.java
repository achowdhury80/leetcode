package com.prep2020.easy;

public class Problem1275 {
	public String tictactoe(int[][] moves) {
        if (isWinner(moves, 0)) return "A";
        if (isWinner(moves, 1)) return "B";
        if (moves.length < 9) return "Pending";
        return "Draw";
    }
	
	private boolean isWinner(int[][] moves, int index) {
		boolean[][] board = new boolean[3][3];
		for (int i = index; i < moves.length; i += 2) board[moves[i][0]][moves[i][1]] = true;
		for (int i = 0; i < 3; i++) {
			boolean flag = true;
			for (int j = 0; j < 3; j++) {
				if (!board[i][j]) {
					flag = false;
					break;
				}
			}
			if (flag) return true;
		}
		for (int i = 0; i < 3; i++) {
			boolean flag = true;
			for (int j = 0; j < 3; j++) {
				if (!board[j][i]) {
					flag = false;
					break;
				}
			}
			if (flag) return true;
		}
		
		if (board[1][1]) {
			if (board[0][0] && board[2][2] || board[2][0] && board[0][2]) return true;
		}
		return false;
		
	}
}
