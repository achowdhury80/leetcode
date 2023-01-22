package com.prep2020.hard;
import java.util.*;
public class Problem1857 {
	/**
	 * O(m + n)
	 * @param colors
	 * @param edges
	 * @return
	 */
	public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Set<Integer>[] nexts = new Set[n];
        for (int i = 0; i < n; i++) nexts[i] = new HashSet<>();
        int[] indeg = new int[n];
        int[][] pathColorCount = new int[n][26];
        int result = 0, count = 0;
        for (int[] edge : edges) {
        	if (edge[0] == edge[1]) return -1;
        	indeg[edge[1]]++;
        	nexts[edge[0]].add(edge[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
        	if (indeg[i] == 0) q.offer(i);
        }
        while(!q.isEmpty() && count < n) {
        	int cur = q.poll();
        	count++;
        	int colorIdx = colors.charAt(cur) - 'a';
        	pathColorCount[cur][colorIdx]++;
        	result = Math.max(result, pathColorCount[cur][colorIdx]);
        	for (int next : nexts[cur]) {
        		indeg[next]--;
        		for (int i = 0; i < 26; i++) pathColorCount[next][i] = Math.max(pathColorCount[next][i], 
        				pathColorCount[cur][i]);
        		if(indeg[next] == 0) q.offer(next);
        	}
        }
        return count == n ? result : -1;
    }
	
	public static void main(String[] args) {
		Problem1857 problem = new Problem1857();
		System.out.println(problem.largestPathValue("abaca", new int[][] {{0,1},{0,2},{2,3},{3,4}}));
	}
}
