package com.prep2020.medium;
import java.util.*;
public class Problem1273 {
	/**
	 * O(n) time and space
	 * @param nodes
	 * @param parent
	 * @param value
	 * @return
	 */
	public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        List<Integer>[] children = new List[nodes];
        for (int i = 0; i < nodes; i++) children[i] = new ArrayList<>();
        for (int i = 1; i < nodes; i++) {
        	children[parent[i]].add(i);
        }
        return findCountNVal(children, value, 0)[0];
    }
	
	private int[] findCountNVal(List<Integer>[] children, int[] value, 
			int node) {
		int val = value[node], count = 1;
		for (int child : children[node]) {
			int[] arr = findCountNVal(children, value, child);
			if (arr[1] != 0) {
				count += arr[0];
				val += arr[1];
			}
		}
		if (val == 0) return new int[] {0, 0};
		return new int[] {count, val};
	}
}
