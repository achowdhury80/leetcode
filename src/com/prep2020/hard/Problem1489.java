package com.prep2020.hard;
import java.util.*;
public class Problem1489 {
	/**
	 * https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/discuss/1478977/100-faster-O(EV)%3A-Building-MST-once-is-enough.
	 * Following 4 steps are required in algo.

Create graph as adjacency matrix of int[][][] type and keep edge weight and indices in the matrix. Indices are kept so that we don't loose track of indices while sorting edges in Kruskal's algo
Create MST using Kruskal's algo on our graph created in step 1. Store this tree in new adjacency list(variable mst in code) and also the set of edges Indices used to create MST(variable mstSet)
For each edge (u,v) not in MST, if there exist edge (x,y) in MST on path from u to v such that cost(u,v) = cost(x,y) then u,v is a psuedo critical edge
For each edge (u,v) in MST, if it is not a psuedo critical edge, then it's a critical edge.
	 * @param n
	 * @param edges
	 * @return
	 */
	public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
		Set<Integer> mstSet = buildMst(n, edges);
        List<Integer> pseudo = new ArrayList<>();
        Set<Integer>[] adjecencyList = new Set[n];
        for (int i = 0; i < n; i++) adjecencyList[i] = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
        	adjecencyList[edges[i][0]].add(i);
        	adjecencyList[edges[i][1]].add(i);
        }
        for (int i = 0; i < edges.length; i++) {
        	if (mstSet.contains(i)) continue;
        	Set<Integer> edgeSet = new HashSet<>();
        	if (foundPathWithSameCost(mstSet, adjecencyList, edges, edges[i][0], edges[i][1], edges[i][2], edgeSet)) {
        		pseudo.add(i);
        		pseudo.addAll(edgeSet);
        	}
        }
        List<Integer> critical = new ArrayList<>();
        for (int i : mstSet) if (!pseudo.contains(i)) critical.add(i);
        return Arrays.asList(critical, pseudo);
    }

	private boolean foundPathWithSameCost(Set<Integer> mstSet, Set<Integer>[] adjecencyList, int[][] edges, 
			int i, int j, int cost, Set<Integer> edgeSet) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, 0});
		Set<Integer> visited = new HashSet<>();
		visited.add(i);
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int e : adjecencyList[cur[0]]) {
				int[] nextEdge = edges[e];
				int nextVertex = -1;
				if (nextEdge[0] == cur[0]) nextVertex = nextEdge[1];
				else nextVertex = nextEdge[0];
				if (visited.contains(nextVertex) || cur[1] + nextEdge[2] > cost) continue;
				edgeSet.add(e);
				if (nextVertex == j && cur[1] + nextEdge[2] == cost) return true;
				q.offer(new int[] {j, cur[1] + nextEdge[2]});
			}
		}
		return false;
	}

	private Set<Integer> buildMst(int n, int[][] edges) {
		List<int[]> edgeList = new ArrayList<>();
		for (int i = 0; i < edges.length; i++) edgeList.add(new int[] {edges[i][0], edges[i][1], edges[i][2], i});
		Collections.sort(edgeList, (x, y) -> x[2] - y [2]);
		Set<Integer> result = new HashSet<>();
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) parent[i] = i;
		
		for (int[] edge : edgeList) {
			int p1 = findParent(edge[0], parent);
			int p2 = findParent(edge[1], parent);
			if (p1 != p2) {
				union(p1, p2, parent);
				result.add(edge[3]);
			}
		}
		return result;
	}

	private void union(int p1, int p2, int[] parent) {
		parent[Math.max(p1, p2)] = Math.min(p1, p2);
	}

	private int findParent(int i, int[] parent) {
		while(i != parent[i]) i = parent[i];
		return i;
	}
	
	public static void main(String[] args) {
		Problem1489 problem = new Problem1489();
		System.out.println(problem.findCriticalAndPseudoCriticalEdges(5, new int[][]{{0,1,1},{1,2,1},{2,3,2},
			{0,3,2},{0,4,3},{3,4,3},{1,4,6}}));
	}
}
