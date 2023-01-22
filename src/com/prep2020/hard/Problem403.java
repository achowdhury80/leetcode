package com.prep2020.hard;
import java.util.*;
public class Problem403 {
	/**
	 * O(N^2) time - two for loops
	 * the hash Map can grow max N^2 size
	 * think about the worst case series. max jump seq would be, 1, 2, 3,..n
	 * O(N^2) space
	 * @param stones
	 * @return
	 */
	public boolean canCross(int[] stones) {
        int n = stones.length;
        if (n < 2) return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        map.put(0, set);
        for (int i = 0; i < n - 1 && !map.containsKey(stones[n - 1]); i++) {
        	if (!map.containsKey(stones[i])) continue;
        	for (int j : map.get(stones[i])) {
        		for (int k = -1; k < 2; k++) {
        			int jump = j + k;
        			if (jump < 1) continue;
        			if (!map.containsKey(stones[i] + jump)) map.put(stones[i] + jump, 
        					new HashSet<>());
        			map.get(stones[i] + jump).add(jump);
        		}
        	}
        }
        return map.containsKey(stones[n - 1]);
    }
	
	public static void main(String[] args) {
		Problem403 problem = new Problem403();
		System.out.println(problem.canCross(new int[] {0,1,3,4,5,7,9,10,12}));
	}
}
