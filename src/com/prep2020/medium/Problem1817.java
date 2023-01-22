package com.prep2020.medium;
import java.util.*;
public class Problem1817 {
	/*
	 * O(N) time and space
	 */
	public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> uam = new HashMap<>();
        for (int[] log : logs) {
        	Set<Integer> set = uam.getOrDefault(log[0], new HashSet<>());
        	set.add(log[1]);
        	uam.put(log[0], set);
        }
        int[] result = new int[k];
        for (Set<Integer> set : uam.values()) {
        	int size = set.size();
        	if (size <= k) result[size - 1]++;
        }
        return result;
    }
}
