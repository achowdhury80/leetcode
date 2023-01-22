package com.prep2020.medium;
import java.util.*;
public class Problem1743 {
	public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        Map<Integer, Set<Integer>> adjacentMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] adj : adjacentPairs) {
        	if (set.contains(adj[0])) set.remove(adj[0]);
        	else set.add(adj[0]);
        	if (set.contains(adj[1])) set.remove(adj[1]);
        	else set.add(adj[1]);
        	Set<Integer> list = adjacentMap.getOrDefault(adj[0], 
        			new HashSet<>());
        	list.add(adj[1]);
        	adjacentMap.put(adj[0], list);
        	list = adjacentMap.getOrDefault(adj[1], 
        			new HashSet<>());
        	list.add(adj[0]);
        	adjacentMap.put(adj[1], list);
        }
        int startElement = set.iterator().next();
        result[0] = startElement;
        for (int i = 1; i < n; i++) {
        	Set<Integer> list = adjacentMap.get(result[i - 1]);
        	Iterator<Integer> itr = list.iterator();
        	while(itr.hasNext()) {
        		int next = itr.next();
        		if (i > 1 && next == result[i - 2]) continue;
        		result[i] = next;
        		break;
        	}
        }
        return result;
    }
}
