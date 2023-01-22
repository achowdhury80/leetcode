package com.prep2020.hard;
import java.util.*;
public class Problem847 {
	/**
	 * O(2^n) time and O(n* 2^n) space
	 * @param graph
	 * @return
	 */
	public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int target = (1 << n) - 1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
        	q.offer(new int[] {i, 1 << i});
        	visited[i][1 << i] = true;
        }
        int result = 0;
        
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		if (cur[1] == target) return result;
        		for (int next : graph[cur[0]]) {
        			int nextState = cur[1] | (1 << next);
        			if (visited[next][nextState]) continue;
        			visited[next][nextState] = true;
        			q.offer(new int[] {next, nextState});
        		}
        	}
        	result++;
        }
        return -1;
    }
}
