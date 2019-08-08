package com.leet.algo;
import java.util.*;
public class Prob996 {
	public int numSquarefulPerms(int[] A) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length - 1; i++) {
        	for (int j = i + 1; j < A.length; j++) {
        		int sqrt = (int)Math.sqrt(A[i] + A[j]);
        		if (sqrt * sqrt == A[i] + A[j]) {
        			List<Integer> list1 = map.getOrDefault(i, new ArrayList<>());
        			list1.add(j);
        			map.put(i, list1);
        			List<Integer> list2 = map.getOrDefault(j, new ArrayList<>());
        			list2.add(i);
        			map.put(j, list2);
        		}
        	}
        }
        int result = 0;
        Set<Integer> similar = new HashSet<>();
        for (int key : map.keySet()) {
        	if (similar.contains(A[key])) continue;
        	Set<Integer> visited = new HashSet<>();
        	visited.add(key);
        	similar.add(A[key]);
        	result += dfs(key, map, A.length, visited, A);
        	visited.remove(key);
        }
        return result;
    }
	
	private int dfs(int start, Map<Integer, List<Integer>> map, int length, Set<Integer> visited, int[] A) {
		if (length == 1) return 1;
		int result = 0;
		Set<Integer> similar = new HashSet<>();
		for (int next : map.get(start)) {
			if (visited.contains(next) || similar.contains(A[next])) continue;
			visited.add(next);
			similar.add(A[next]);
			result += dfs(next, map, length - 1, visited, A);
			visited.remove(next);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Prob996 prob = new Prob996();
		System.out.println(prob.numSquarefulPerms(new int[] {1, 17, 8}));
		System.out.println(prob.numSquarefulPerms(new int[] {2, 2, 2}));
	}
}
