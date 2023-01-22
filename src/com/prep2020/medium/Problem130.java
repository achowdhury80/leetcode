package com.prep2020.medium;
import java.util.*;
public class Problem130 {
	public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
        	if (board[i][0] == 'O') {
        		q.offer(new int[] {i, 0});
        		board[i][0] = 'Y';
        	}
        	if (n > 1 && board[i][n - 1] == 'O') {
        		q.offer(new int[] {i, n - 1});
        		board[i][n - 1] = 'Y';
        	}
        }
        
        for (int j = 0; j < n; j++) {
        	if (board[0][j] == 'O') {
        		q.offer(new int[] {0, j});
        		board[0][j] = 'Y';
        	}
        	if (m > 1 && board[m - 1][j] == 'O') {
        		q.offer(new int[] {m - 1, j});
        		board[m - 1][j] = 'Y';
        	}
        }
        
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	for (int[] dir : dirs) {
        		int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        		if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n || board[next[0]][next[1]] != 'O') continue;
        		board[next[0]][next[1]] = 'Y';
        		q.offer(next);
        	}
        }
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (board[i][j] == 'O') board[i][j] = 'X';
        		else if (board[i][j] == 'Y') board[i][j] = 'O';
        	}
        }
    }
}
