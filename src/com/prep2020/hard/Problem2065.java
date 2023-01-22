package com.prep2020.hard;
import java.util.*;
public class Problem2065 {
	public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
		int n = values.length;
		List<int[]>[] nexts = new List[n];
		for (int i = 0; i < n; i++) nexts[i] = new ArrayList<>();
		for (int[] e : edges) {
			nexts[e[0]].add(new int[] {e[1], e[2]});
			nexts[e[1]].add(new int[] {e[0], e[2]});
		}
        int[] result = new int[1];
        solve(values, nexts, new int[n], 0, maxTime, 0, 0, result);
        return result[0];
    }
    
    void solve(int[] values, List<int[]>[] nexts, int[] visited, int cur, int maxTime, int curTime, int score, 
    		int[] result) {
        if (curTime > maxTime) return;
        if (visited[cur] == 0) score += values[cur];
        if (cur == 0) result[0] = Math.max(result[0], score);
        visited[cur]++;
        for (int[] next : nexts[cur]) {
        	solve(values, nexts, visited, next[0], maxTime, curTime + next[1], score, result);
        }
        visited[cur]--;
    }
    
    public static void main(String[] args) {
    	Problem2065 problem = new Problem2065();
    	System.out.println(problem.maximalPathQuality(new int[] {0, 32, 10, 43}, new int[][]{{0,1,10},{1,2,15},{0,3,10}}, 49));
    }

}
