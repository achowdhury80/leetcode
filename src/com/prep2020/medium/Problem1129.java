package com.prep2020.medium;
import java.util.*;
public class Problem1129 {
	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] result = new int[n];
        for (int i = 1; i < n; i++) result[i] = Integer.MAX_VALUE;
        Set<Integer>[][] nexts = new Set[2][n];
        for (int i = 0; i < n; i++) {
        	nexts[0][i] = new HashSet<>();
        	nexts[1][i] = new HashSet<>();
        }
        for (int[] red : redEdges) nexts[0][red[0]].add(red[1]);
        for (int[] blue : blueEdges) nexts[1][blue[0]].add(blue[1]);
        Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		q.offer(new int[] {0, 1});
		boolean[][] visited = new boolean[result.length][2];
		visited[0][0] = true;
		visited[0][1] = true;
        int path = 0;
        while(!q.isEmpty()) {
        	path++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int nextColor = (cur[1] + 1) % 2;
				for (int next : nexts[nextColor][cur[0]]) {
					if (!visited[next][nextColor]) {
						visited[next][nextColor] = true;
						result[next] = Math.min(result[next], path);
						q.offer(new int[] {next, nextColor});
					}
				}
			}
        }
        for(int i = 1; i < n; i++) if (result[i] == Integer.MAX_VALUE) result[i] = -1;
        return result;
    }
}
