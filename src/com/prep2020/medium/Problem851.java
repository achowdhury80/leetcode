package com.prep2020.medium;
import java.util.*;
public class Problem851 {
	public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] r : richer) {
        	Set<Integer> set = map.getOrDefault(r[1], new HashSet<>());
        	set.add(r[0]);
        	map.put(r[1], set);
        }
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
        	result[i] = findQuietstPerson(map, quiet, i);
        }
        return result;
    }
	
	private int findQuietstPerson(Map<Integer, Set<Integer>> map, int[] quiet, int i) {
		if (!map.containsKey(i)) return i;
		int result = i;
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		Set<Integer> visited = new HashSet<>();
		visited.add(i);
		while(!q.isEmpty()) {
			int p = q.poll();
			if (map.containsKey(p)) {
				Set<Integer> next = map.get(p);
				for (int n : next) {
					if (!visited.contains(n)) {
						if (quiet[result] > quiet[n]) {
							result = n;
						}
						visited.add(n);
						q.offer(n);
					}
				}
			}
		}
		return result;
	}
	
}
