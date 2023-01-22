package com.prep2020.medium;
import java.util.*;
public class Problem886 {
	public boolean possibleBipartition(int n, int[][] dislikes) {
        Set<Integer>[] groups = new Set[2];
        groups[0] = new HashSet<>();
        groups[1] = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] a : dislikes) {
        	Set<Integer> set = map.getOrDefault(a[0], new HashSet<>());
        	set.add(a[1]);
        	map.put(a[0], set);
        	set = map.getOrDefault(a[1], new HashSet<>());
        	set.add(a[0]);
        	map.put(a[1], set);
        }
        for (int i = 1; i <= n; i++) {
        	if (groups[0].contains(i) || groups[1].contains(i)) continue;
        	if (!helper(i, 0, map, groups)) return false;
        }
        return true;
    }
	
	private boolean helper(int cur, int groupId, Map<Integer, 
			Set<Integer>> map, Set<Integer>[] groups) {
		groups[groupId].add(cur);
		if (!map.containsKey(cur)) return true;
		for (int next : map.get(cur)) {
			if (groups[groupId].contains(next)) return false;
			if (groups[(groupId + 1) % 2].contains(next)) continue;
			if (!helper(next, (groupId + 1) % 2, map, groups)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Problem886 problem = new Problem886();
		System.out.println(problem.possibleBipartition(4, new int[][] {{1,2},{1,3},{2,4}}));
	}
}
