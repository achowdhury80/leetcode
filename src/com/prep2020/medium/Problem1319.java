package com.prep2020.medium;

public class Problem1319 {
	public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int parents = n;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] conn : connections) {
        	int p0 = findParent(conn[0], parent), 
        			p1 = findParent(conn[1], parent); 
        	if (p0 != p1) {
        		parent[Math.max(p0, p1)] = Math.min(p0, p1);
        		parents--;
        	}
        }
        return parents - 1;
    }
	
	private int findParent(int node, int[] parent) {
		while(parent[node] != node) node = parent[node];
		return node;
	}
}
