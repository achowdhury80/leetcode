package com.prep2020.medium;
import java.util.*;
public class Problem1584 {
	/**
	 * O(N^2)log(n^2)
	 * start with first point, mark it visited
	 * put all other non-visited nodes and distance in the priority queue from the last 
	 * node.
	 * pick the one with smallest distance and so on 
	 * @param points
	 * @return
	 */
	public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[] {0, 0});
        int result = 0, count = 0;
        while(!pq.isEmpty() && count < n) {
        	int[] node = pq.poll();
        	if (visited[node[0]]) continue;
        	result += node[1];
        	visited[node[0]] = true;
        	count++;
        	for (int i = 0; i < n; i++) {
            	if (i != node[0] && !visited[i]) pq.offer(new int[] {i, Math.abs(points[node[0]][0] - points[i][0])
            			+ Math.abs(points[node[0]][1] - points[i][1])});
        	}
        }
        return result;
        	
    }
}
