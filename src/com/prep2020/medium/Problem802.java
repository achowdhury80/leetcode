package com.prep2020.medium;
import java.util.*;
public class Problem802 {
	public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] outdegree = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
        	for (int j : graph[i]) {
        		outdegree[i]++;
        		Set<Integer> set = map.getOrDefault(j, new HashSet<>());
        		set.add(i);
        		map.put(j, set);
        	}
        }
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
        	if (outdegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	result.add(cur);
        	Set<Integer> set = map.get(cur);
        	if (set != null) {
        		for (int node : set) {
        			outdegree[node]--;
        			if (outdegree[node] == 0) q.offer(node);
        		}
        	}
        }
        Collections.sort(result);
        return result;
    }
}
