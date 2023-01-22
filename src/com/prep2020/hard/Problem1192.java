package com.prep2020.hard;
import java.util.*;
public class Problem1192 {
	/**
	 * O(V + E)
	 * tarjan's algo
	 * @param n
	 * @param connections
	 * @return
	 */
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] low = new int[n];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] nexts = new List[n];
        for (int i = 0; i < n; i++) nexts[i] = new ArrayList<>();
        for (List<Integer> conn : connections) {
        	nexts[conn.get(0)].add(conn.get(1));
        	nexts[conn.get(1)].add(conn.get(0));
        }
        dfs(low, 0, nexts, 0, -1, result, new boolean[n]);
        return result;
    }
	
	private void dfs(int[] low, int time, List<Integer>[] nexts, int cur, int parent, 
			List<List<Integer>> result, boolean[] visited) {
		visited[cur] = true;
		low[cur] = time;
		for (Integer next : nexts[cur]) {
			if (parent == next) continue;
			if (!visited[next]) dfs(low, time + 1, nexts, next, cur, result, visited);
			low[cur] = Math.min(low[cur], low[next]);
			if (time < low[next]) result.add(Arrays.asList(cur, next));
		}
	}
}
