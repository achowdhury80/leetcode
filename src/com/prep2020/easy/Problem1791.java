package com.prep2020.easy;
import java.util.*;
public class Problem1791 {
	/**
	 * O(N) time and space
	 * @param edges
	 * @return
	 */
	public int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int[] edge : edges) {
        	if (!set.add(edge[0])) return edge[0];
        	if (!set.add(edge[1])) return edge[1];
        }
        return -1;
    }
}
