package com.prep2020.hard;
import java.util.*;
public class Problem2050 {
	/**
	 * O(m + n) time and space
	 * Maintain the possible start time along with indeg count
	 * @param n
	 * @param relations
	 * @param time
	 * @return
	 */
	public int minimumTime(int n, int[][] relations, int[] time) {
        int[][] indeg = new int[n][2];
        Set<Integer>[] nexts = new Set[n];
        for (int i = 0; i < n; i++) nexts[i] = new HashSet<>();
        for (int[] rel : relations) {
        	nexts[rel[0] - 1].add(rel[1] - 1);
        	indeg[rel[1] - 1][0]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
        	if (indeg[i][0] == 0) q.offer(i);
        }
        int count = 0, result = 0;
        while(!q.isEmpty() && count < n) {
        	int cur = q.poll();
        	count++;
        	int endTime = indeg[cur][1] + time[cur];
        	result = Math.max(result, endTime);
        	for (int next : nexts[cur]) {
        		indeg[next][0]--;
        		indeg[next][1] = Math.max(indeg[next][1], endTime);
        		if (indeg[next][0] == 0) q.offer(next);
        	}
        }
        return result;
    }
}
