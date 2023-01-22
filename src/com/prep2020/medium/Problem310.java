package com.prep2020.medium;
import java.util.*;
public class Problem310 {
	/**
	 * o(v + e) time and o(e) space
	 * @param n
	 * @param edges
	 * @return
	 */
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> result = new ArrayList<>();
		if (n == 1) {
			result.add(0);
			return result;
		}
        int[] indegree = new int[n];
        Set<Integer>[] nexts = new Set[n];
        for (int i = 0; i < n; i++) nexts[i] = new HashSet<>();
        for (int[] e : edges) {
        	nexts[e[0]].add(e[1]);
        	nexts[e[1]].add(e[0]);
        	indegree[e[0]]++;
        	indegree[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
        	if (indegree[i] == 1) q.offer(i);
        }
        
        while(!q.isEmpty()) {
        	result.clear();
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		result.add(cur);
        		for(int next : nexts[cur]) {
        			indegree[next]--;
        			if (indegree[next] == 1) q.offer(next);
        		}
        	}
        }
        return result;
    }
}
