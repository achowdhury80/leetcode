package com.prep2020.medium;
import java.util.*;
public class Problem1102 {
	public int maximumMinimumPath(int[][] A) {
        int r = A.length, c = A[0].length;
        Queue<int[]> q = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        q.offer(new int[] {A[0][0], 0, 0});
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        A[0][0] = -1;
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	if (cur[1] == r - 1 && cur[2] == c - 1) return cur[0];
        	for (int[] dir : dirs) {
        		int[] next = new int[] {cur[1] + dir[0], cur[2] + dir[1]};
        		if (next[0] < 0 || next[0] >= r || next[1] < 0 || next[1] >= c || A[next[0]][next[1]] == -1) continue;
        		q.offer(new int[] {Math.min(cur[0], A[next[0]][next[1]]), next[0], next[1]});
                A[next[0]][next[1]] = -1;
        	}
        }
        return -1;
        
    }
}
