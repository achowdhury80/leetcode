package com.leet.algo;
import java.util.*;
public class Prob909 {
	public int snakesAndLadders(int[][] board) {
		int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q.add(1);
        seen.add(1);
        int result = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	result++;
        	for (int i = 0; i < size; i++) {
        		int num = q.poll();
        		for (int j = 1; j < 7; j++) {
        			int next = num + j;
        			if (next > n * n) break;
        			int[] gridPos = findPos(next, n);
        			if (board[gridPos[0]][gridPos[1]] != -1) next = board[gridPos[0]][gridPos[1]];
        			if (!seen.contains(next)) {
        				if (next == n * n) return result;
        				q.offer(next);
        				seen.add(next);
        			}
        		}
        	}
        }
        return -1;
    }
	
	private int[] findPos(int num, int N) {
		int row = N - (num - 1) / N - 1;
		int rowIdxFromBottom = (num - 1) / N;
		boolean right = rowIdxFromBottom % 2 == 0;
		int start = rowIdxFromBottom * N + 1;
		int offset = num - start;
		int col = 0;
		if (!right) {
			col = N - 1;
			col -= offset;
		} else col += offset;
		
		return new int[] {row, col};
	}
}
