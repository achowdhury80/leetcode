package com.prep2020.hard;

public class Problem1438 {
	int[] parent;
	public Problem1438(int n, int[] parent) {
        this.parent = parent;
    }
    
    public int getKthAncestor(int node, int k) {
        if (parent[node] == -1) return -1;
        if (k == 1) return parent[node];
        return getKthAncestor(parent[node], k - 1);
    }
}
