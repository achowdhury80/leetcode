package com.prep2020.medium;

public class Problem684 {
	public int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;
        for (int[] edge : edges) {
        	int p1 = findParent(edge[0], parent), p2 = findParent(edge[1], parent);
        	if (p1 == p2) return edge.clone();
        	if (p1 < p2) parent[p2] = p1;
        	else parent[p1] = p2;
        }
        return null;
    }
	
	private int findParent(int n, int[] parent) {
		while (parent[n] != n) n = parent[n];
		return n;
	}
}
