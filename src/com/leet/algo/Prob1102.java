package com.leet.algo;
import java.util.*;
public class Prob1102 {
	public int maximumMinimumPath(int[][] A) {
        int r = A.length, c = A[0].length;
        Queue<int[]> q = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        q.offer(new int[] {A[0][0], 0, 0});
        A[0][0] = -1;
        int min = Integer.MAX_VALUE;
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while(!q.isEmpty()) {
        	int[] t = q.poll();
        	min = Math.min(min, t[0]);
        	if (t[1] == r - 1 && t[2] == c - 1) return min;
        	for (int[] dir : dirs) {
        		int[] next = new int[] {t[1] + dir[0], t[2] + dir[1]};
        		if (next[0] < 0 || next[0] >= r || next[1] < 0 || next[1] >= c || A[next[0]][next[1]] == -1) continue;
        		q.offer(new int[] {A[next[0]][next[1]], next[0], next[1]});
                A[next[0]][next[1]] = -1;
        	}
        }
        return min;
        
    }
}
