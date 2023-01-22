package com.prep2020.medium;
import java.util.*;
public class Problem1306 {
	/**
	 * O(N)
	 * BFS
	 * @param arr
	 * @param start
	 * @return
	 */
	public boolean canReach(int[] arr, int start) {
		if(arr[start] == 0) return true;
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	int next = cur + arr[cur], prev = cur - arr[cur];
        	if (next < arr.length) {
        		if (arr[next] == 0) return true;
        		if (!visited[next]) {
        			q.offer(next);
        			visited[next] = true; 
        		} 
        	}
        	if (prev > -1) {
        		if (arr[prev] == 0) return true;
        		if (!visited[prev]) {
        			q.offer(prev);
        			visited[prev] = true; 
        		} 
        	}
        }
        return false;
    }
}
