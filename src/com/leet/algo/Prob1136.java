package com.leet.algo;
import java.util.*;
public class Prob1136 {
	//O(m + n)
	public int minimumSemesters(int N, int[][] relations) {
        int[] indegree = new int[N + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : relations) {
        	List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
        	list.add(edge[1]);
        	map.put(edge[0], list);
        	indegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
        	if (indegree[i] == 0) q.offer(i);
        }
        int count = 0;
        int result = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	result++;
        	for (int i = 0; i < size; i++) {
        		int node = q.poll();
        		count++;
        		if(map.get(node) != null) {
        			for (int next : map.get(node)) {
        				indegree[next]--;
        				if (indegree[next] == 0) q.offer(next);
        			}
        		}
        		
        	}
        }
        return count == N ? result : -1;
    }
	
	public static void main(String[] args) {
		Prob1136 prob = new Prob1136();
		System.out.println(prob.minimumSemesters(3, new int[][] {{1, 3},{2, 3}}));
	}
}
