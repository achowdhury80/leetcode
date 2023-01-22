package com.prep2020.medium;
import java.util.*;
public class Problem1722 {
	public int minimumHammingDistance(int[] source, int[] target, 
			int[][] allowedSwaps) {
        int n = source.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] s : allowedSwaps) {
        	int p0 = findParent(s[0], parent);
        	int p1 = findParent(s[1], parent);
        	if (p0 != p1) {
        		parent[Math.max(p0, p1)] = Math.min(p0, p1);
        	}
        }
        Map<Integer, Set<Integer>> loops = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	int p = findParent(i, parent);
        	Set<Integer> set = loops.getOrDefault(p, new HashSet<>());
        	set.add(i);
        	loops.put(p, set);
        }
        int result = 0;
        for (Set<Integer> set : loops.values()) {
        	Map<Integer, Integer> l1 = new HashMap<>(), l2 = new HashMap<>();
        	for (int i : set) {
        		l1.put(source[i], l1.getOrDefault(source[i], 0) + 1);
        		l2.put(target[i], l2.getOrDefault(target[i], 0) + 1);
        	}
        	int common = 0;
        	for (int i : l1.keySet()) {
        		if (l2.containsKey(i)) common += Math.min(l1.get(i), l2.get(i));
        	}
        	result += (set.size() - common);
        }
        return result;
    }

	private int findParent(int i, int[] parent) {
		while(i != parent[i]) i = parent[i];
		return i;
	}
	
	public static void main(String[] args) {
		Problem1722 problem = new Problem1722();
		System.out.println(problem.minimumHammingDistance(new int[] {1,2,3,4},
				new int[] {2,1,4,5},
				new int[][] {{0,1},{2,3}}));
	}
}
