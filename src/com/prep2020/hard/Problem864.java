package com.prep2020.hard;
import java.util.*;
public class Problem864 {
	public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int keys = 0;
        int[] start = new int[] {-1, -1};
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		char c;
        		if ("abcdef".indexOf(c = grid[i].charAt(j)) > -1) keys++;
        		if (c == '@') start = new int[] {i, j};
        	}
        }
        int[][][] dist = new int[m][n][1 << keys];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		for (int k = 0; k < (1 << keys); k++) dist[i][j][k] = Integer.MAX_VALUE;
        	}
        }
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> (x[3] == y[3]) ? ((Integer.bitCount(y[2] - Integer.bitCount(x[2])))) : (x[3] - y[3]));
        int[] begin = new int[] {start[0], start[1], 0, 0};
        pq.offer(begin);
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (dist[cur[0]][cur[1]][cur[2]] <= cur[3]) continue;
        	dist[cur[0]][cur[1]][cur[2]] = cur[3];
        	if (cur[2] == (1 << keys) - 1) return cur[3];
        	for (int[] dir : dirs) {
        		int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1], cur[2], cur[3] + 1};
        		if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n) continue;
        		char c = grid[next[0]].charAt(next[1]);
        		if (c == '#') continue;
        		int idx = -1;
        		if ((idx = "abcdef".indexOf(c)) > -1) {
        			next[2] |= (1 << idx);
        		} else if ((idx = "ABCDEF".indexOf(c)) > -1) {
        			if ((next[2] & (1 << idx)) == 0) continue;
        		}
        		pq.offer(next);
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Problem864 problem = new Problem864();
		System.out.println(problem.shortestPathAllKeys(new String[] {"@.a..","###.#","b.A.B"}));
	}
}
