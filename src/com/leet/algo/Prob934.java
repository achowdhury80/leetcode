package com.leet.algo;
import java.util.*;
public class Prob934 {
	public int shortestBridge(int[][] A) {
        int r = -1, c = -1;
        for (int i = 0; i < A.length; i++) {
        	for (int j = 0; j < A[0].length; j++) {
        		if(A[i][j] == 1) {
        			r = i;
        			c = j;
        			break;
        		}
        	}
        }
        A[r][c] = 2;
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        q1.offer(new int[] {r, c});
        q2.offer(new int[] {r, c});
        int[][] dirs = new int[][] {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q1.isEmpty()) {
        	int size = q1.size();
        	for (int i = 0; i < size; i++) {
        		int[] pos = q1.poll();
        		for (int[] dir : dirs) {
        			int[] next = new int[] {pos[0] + dir[0], pos[1] + dir[1]};
        			if (next[0] > -1 && next[0] < A.length && next[1] > -1 && next[1] < A[0].length && A[next[0]][next[1]] == 1) {
        				A[next[0]][next[1]] = 2;
        				q1.offer(next);
        				q2.offer(next);
        			}
        		}
        	}
        }
        int result = 0;
        while (!q2.isEmpty()) {
        	result++;
        	int size = q2.size();
        	for (int i = 0; i < size; i++) {
        		int[] pos = q2.poll();
        		for (int[] dir : dirs) {
        			int[] next = new int[] {pos[0] + dir[0], pos[1] + dir[1]};
        			if (next[0] > -1 && next[0] < A.length && next[1] > -1 && next[1] < A[0].length && A[next[0]][next[1]] != 2) {
        				if(A[next[0]][next[1]] == 1) return result - 1;
        				A[next[0]][next[1]] = 2;
        				q2.offer(next);
        			}
        		}
        	}
        }
        return -1;
    }
}
