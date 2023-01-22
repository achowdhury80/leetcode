package com.prep2020.medium;
import java.util.*;
public class Problem1466 {
	/**
	 * O(N)
	 * @param n
	 * @param connections
	 * @return
	 */
	public int minReorder(int n, int[][] connections) {
        boolean[] used = new boolean[n];
        List<Integer>[] connected = new List[n];
        for (int i = 0; i < connections.length; i++) {
        	int[] conn = connections[i];
        	if (connected[conn[0]] == null) connected[conn[0]] = new ArrayList<>();
        	if (connected[conn[1]] == null) connected[conn[1]] = new ArrayList<>();
        	connected[conn[0]].add(i);
        	connected[conn[1]].add(i);
        }
        used[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int result = 0;
        while(!q.isEmpty()) {
        	int node = q.poll();
        	List<Integer> edges = connected[node];
        	for (int edge : edges) {
        		int[] conn = connections[edge];
        		int next = conn[1];
        		if (conn[1] == node) {
        			next = conn[0];
        		} 
        		if (!used[next]) {
        			used[next] = true;
        			if (next == conn[1]) result++;
        			q.offer(next);
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1466 problem = new Problem1466();
		System.out.println(problem.minReorder(6, 
				new int[][] {{0,1},{1,3},{2,3},{4,0},{4,5}}));
	}
}
