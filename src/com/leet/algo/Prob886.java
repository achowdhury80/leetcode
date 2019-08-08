package com.leet.algo;
import java.util.*;
public class Prob886 {
	public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] graph = new List[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int[] edge : dislikes) {
        	graph[edge[0]].add(edge[1]);
        	graph[edge[1]].add(edge[0]);
        }
        Map<Integer, Integer> colorMap = new HashMap<>();
        for (int node = 1; node <= N; node++) {
        	if (!colorMap.containsKey(node) 
        			&& !dfs(node, 0, colorMap, graph)) return false;
        }
        return true;
    }
	
	private boolean dfs(int node, int color, Map<Integer, Integer> colorMap, 
			List<Integer>[] graph) {
		if (colorMap.containsKey(node)) return colorMap.get(node) == color;
		colorMap.put(node, color);
		for (int nei : graph[node]) {
			if (!dfs(nei, color ^ 1, colorMap, graph)) return false;
		}
		return true;
	}
}
