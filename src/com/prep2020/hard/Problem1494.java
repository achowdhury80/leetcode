package com.prep2020.hard;
import java.util.*;
public class Problem1494 {
	public int minNumberOfSemesters(int n, int[][] relations, int k) {
        Set<Integer>[] nexts = new Set[n];
        for (int i = 0; i < n; i++) nexts[i] = new HashSet<>();
        int[] indeg = new int[n];
        for (int[] e : relations) {
        	nexts[e[0] - 1].add(e[1] - 1);
        	indeg[e[1] - 1]++;
        }
        int result = 0;
        Queue<Integer> q = new PriorityQueue<>((x, y) -> nexts[y].size() - nexts[x].size());
        for (int i = 0; i < n; i++) {
        	if (indeg[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	List<Integer> temp = new ArrayList<>();
        	for (int i = 0; i < Math.min(size, k); i++) {
        		int cur = q.poll();
        		for (int next : nexts[cur]) {
        			indeg[next]--;
        			if (indeg[next] == 0) temp.add(next);
        		}
        	}
        	for (int i : temp) q.offer(i);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1494 problem = new Problem1494();
		System.out.println(problem.minNumberOfSemesters(8, new int[][]{{2,7},{1,6},{2,8},{8,7},{6,7},{5,4},{1,7},
			{1,2},{1,4},{2,6}}, 3));
	}
}
