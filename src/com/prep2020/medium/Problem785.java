package com.prep2020.medium;
public class Problem785 {
	/**
	 * O(N)
	 * @param graph
	 * @return
	 */
	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) color[i] = -1;
        for (int i = 0; i < n; i++) {
        	if (color[i] != -1) continue;
        	if (!dfs(i, 0, color, graph)) return false;
        }
        return true;
    }

	private boolean dfs(int node, int curColor, int[] color, int[][] graph) {
		color[node] = curColor;
		if (graph[node] == null) return true;
		for (int next : graph[node]) {
			if (color[next] == curColor) return false;
			if (color[next] != -1) continue;
			if (!dfs(next, (curColor + 1) % 2, color, graph)) return false;
		}
		return true;
	}
}
