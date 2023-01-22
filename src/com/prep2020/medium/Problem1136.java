package com.prep2020.medium;
import java.util.*;
public class Problem1136 {
	/**
	 * O(N)
	 * @param n
	 * @param relations
	 * @return
	 */
	public int minimumSemesters(int n, int[][] relations) {
        int[] inDegree = new int[n + 1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] rel : relations) {
        	inDegree[rel[1]]++;
        	Set<Integer> dependants = map.getOrDefault(rel[0], new HashSet<>());
        	dependants.add(rel[1]);
        	map.put(rel[0], dependants);
        }
        Queue<Integer> q = new LinkedList<>();
        int completed = 0;
        for (int i = 1; i <= n; i++) {
        	if (inDegree[i] == 0) q.offer(i);
        }
        int result = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		completed++;
        		Set<Integer> dependants = map.getOrDefault(cur, new HashSet<>());
        		for (int course : dependants) {
        			inDegree[course]--;
        			if (inDegree[course] == 0) q.offer(course);
        		}
        	}
        	result++;
        }
        return completed == n ? result : -1;
    }
}
