package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2077 {
	public int numberOfPaths(int n, int[][] corridors) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) map.put(i, new HashSet<>());
        for (int[] e : corridors) {
        	if (e[0] < e[1]) map.get(e[0]).add(e[1]);
        	else map.get(e[1]).add(e[0]);
        }
        int result = 0;
        for (int[] e : corridors) {
        	Set<Integer> s0 = map.get(e[0]), s1 = map.get(e[1]);
        	for (int i : s0) {
        		if (s1.contains(i)) result++;
        	}
        }
        return result;
    }
}
