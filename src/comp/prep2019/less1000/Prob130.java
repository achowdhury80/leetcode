package comp.prep2019.less1000;

import java.util.LinkedList;
import java.util.Queue;

public class Prob130 {
	public void solve(char[][] board) {
        int m, n;
        if (board == null || (m = board.length) < 1 || (n= board[0].length) < 1) 
        	return;
        // start only from boundarys
        for (int i = 0; i < m; i++) {
        	if (board[i][0] == 'O') populate(board, new int[] {i, 0});
        	if (board[i][n - 1] == 'O') populate(board, new int[] {i, n - 1});
        }
        for (int j = 0; j < n; j++) {
        	if (board[0][j] == 'O') populate(board, new int[] {0, j});
        	if (board[m - 1][j] == 'O') populate(board, new int[] {m - 1, j});
        }
        
        adjust(board);
    }
	
	// make reachable O's to P
	private void populate(char[][] board, int[] cur) {
		int m = board.length, n = board[0].length;
		int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		Queue<int[]> q = new LinkedList<>();
		q.offer(cur);
		board[cur[0]][cur[1]] = 'P';
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			for (int[] dir : dirs) {
				int[] next = new int[] {pos[0] + dir[0], pos[1] + dir[1]};
				if (next[0] > -1 && next[0] < m && next[1] > -1 && next[1] < n
						&& board[next[0]][next[1]] == 'O') {
					q.offer(next);
					board[next[0]][next[1]] = 'P';
				}
			}
		}
	}
	
	// make P's to O and O's to X
	private void adjust(char[][] board) {
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') board[i][j] = 'X';
				else if (board[i][j] == 'P') board[i][j] = 'O';
			}
		}
	}
}
