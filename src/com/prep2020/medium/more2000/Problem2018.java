package com.prep2020.medium.more2000;

public class Problem2018 {
	public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length, n = board[0].length, len = word.length();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (board[i][j] == '#') continue;
        		if (j == 0 || board[i][j - 1] == '#') {
        			if (j + len > n) break;
        			if (j + len == n  || board[i][j + len] == '#') {
        				if (isFound(board, new int[] {i, j}, new int[] {0, 1}, word)
        						|| isFound(board, new int[] {i, j + len - 1}, 
        								new int[] {0, -1}, word)) return true;
        			}
        		}
        	}
        }
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (board[j][i] == '#') continue;
        		if (j == 0 || board[j - 1][i] == '#') {
        			if (j + len > m) break;
        			if (j + len == m  || board[j + len][i] == '#') {
        				if (isFound(board, new int[] {j, i}, new int[] {1, 0}, word)
        						|| isFound(board, new int[] {j + len - 1, i}, 
        								new int[] {-1, 0}, word)) return true;
        			}
        		}
        	}
        }
        return false;
    }
	
	private boolean isFound(char[][] board, int[] start, int[] dir, String word) {
		int[] cur = start;
		for (int i = 0; i < word.length(); i++) {
			if (board[cur[0]][cur[1]] != word.charAt(i) && board[cur[0]][cur[1]] != ' ')
				return false;
			cur = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
		}
		return true;
	}
	
	public static void main(String[] args) {
		Problem2018 problem = new Problem2018();
		System.out.println(problem.placeWordInCrossword(new char[][]{{'#', ' ', '#'}, 
			{' ', ' ', '#'}, {'#', 'c', ' '}}, "abc"));
	}
}
