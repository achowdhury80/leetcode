package com.prep2020.medium;

public class Problem323 {
	public int countComponents(int n, int[][] edges) {
        int result = n;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] edge : edges) {
        	int p1 = findParent(edge[0], parent);
        	int p2 = findParent(edge[1], parent);
        	if (p1 != p2) {
        		result--;
        		parent[Math.max(p1, p2)] = Math.min(p1, p2);
        	}
        }
        return result;
    }
	
	private int findParent(int node, int[] parent) {
		while(node != parent[node]) node = parent[node];
		return node;
	}
}
