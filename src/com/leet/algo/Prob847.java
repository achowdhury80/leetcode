package com.leet.algo;
import java.util.*;
public class Prob847 {
	/**
	 * Since the maximum number of nodes in the graph is 12 and int is 32 bits in Java, we can use an int to represent the state. The rightmost n bits of the int stores the visited node, where n is the graph.length, and the left part stores the node number.

For example, given graph.length == 5 and the current node is 4 and visited nodes are [1,2,3], the state represented as int will be 100 01110. The rightmost 5 bits 01110 means nodes [1,2,3] have been visited and 100 on the left means the current node is 4.
	 * @param graph
	 * @return
	 */
	public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int mask = (1 << n) - 1;
        boolean[][] visited = new boolean[n][1 << n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
        	int state = (i << n) | (1 << i);
        	q.add(state);
        	visited[i][1 << i] = true;
        }
        int result = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int state = q.poll();
        		int status = state & mask;
        		if (status == mask) return result;
        		int node = state >> n;
        		for (int next : graph[node]) {
        			int newStatus = status | (1 << next);
        			int newState = (next << n) | newStatus;
        			if(!visited[next][newStatus]) {
        				visited[next][newStatus] = true;
        				q.offer(newState);
        			}
        		}
        	}
        	result++;
        }
        return -1;
    }
}
