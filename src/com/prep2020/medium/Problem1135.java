package com.prep2020.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Problem1135 {
	/**
	 * Prims algo for minimum spanning tree
	 * O(mlogn)
	 * @param N
	 * @param connections
	 * @return
	 */
	public int minimumCost(int N, int[][] connections) {
        int result = 0;
        List<int[]>[] edges = new List[N + 1];
        for (int[] connection : connections) {
        	if (edges[connection[0]] == null) edges[connection[0]] = new ArrayList<>();
        	if (edges[connection[1]] == null) edges[connection[1]] = new ArrayList<>();
        	edges[connection[0]] .add(new int[] {connection[1], connection[2]});
        	edges[connection[1]] .add(new int[] {connection[0], connection[2]});
        	
        }
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        q.offer(new int[] {1, 0});
        int count = 0;
        while(!q.isEmpty() && count < N) {
        	int[] node = q.poll();
        	if (visited.contains(node[0])) continue;
        	result += node[1];
        	count++;
        	visited.add(node[0]);
        	if (edges[node[0]] != null) {
        		for (int[] edge : edges[node[0]]) {
        			if (!visited.contains(edge[0])) q.offer(edge);
        		}
        	}
        }
        return count == N ? result : -1;
    }
}
