package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2192 {
	public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new HashSet<>());
        int[] indeg = new int[n];
        Map<Integer, List<Integer>> nexts = new HashMap<>();
        for (int i = 0; i < n; i++) nexts.put(i, new ArrayList<>());
        for (int[] e : edges) {
        	indeg[e[1]]++;
        	List<Integer> next = nexts.getOrDefault(e[0], new ArrayList<>());
        	next.add(e[1]);
        	nexts.put(e[0], next);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
        	if(indeg[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	for (int next : nexts.get(cur)) {
        		indeg[next]--;
        		if (indeg[next] == 0) q.offer(next);
        		list.get(next).add(cur);
        		list.get(next).addAll(list.get(cur));
        	}
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	result.add(new ArrayList<>(list.get(i)));
        	Collections.sort(result.get(i));
        }
        return result;
    }
}
