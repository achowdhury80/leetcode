package com.prep2020.hard;
import java.util.*;
public class Problem1761 {
	/**
	 * O(n^3)
	 * @param n
	 * @param edges
	 * @return
	 */
	public int minTrioDegree(int n, int[][] edges) {
		Set<Integer>[] nexts = new Set[n];
		for (int i = 0; i < n; i++) nexts[i] = new HashSet<>();
		for (int[] e : edges) {
			nexts[e[0] - 1].add(e[1] - 1);
			nexts[e[1] - 1].add(e[0] - 1);
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				if(!nexts[i].contains(j)) continue;
				for (int k = j + 1; k < n; k++) {
					if (!nexts[j].contains(k) || !nexts[k].contains(i)) continue;
					result = Math.min(result, nexts[i].size() + nexts[j].size() 
							+ nexts[k].size() - 6);
				}
			}
		}
		
		return result == Integer.MAX_VALUE ? -1 : result;
    }
	
	public static void main(String[] args) {
		Problem1761 problem = new Problem1761();
		System.out.println(problem.minTrioDegree(6,  new int[][]{{6,5},{4,3},{5,1},{1,4},{2,3},{4,5},{2,6},{1,3}}));
	}
}
