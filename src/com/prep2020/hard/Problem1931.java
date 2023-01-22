package com.prep2020.hard;
import java.util.*;
public class Problem1931 {
	public int colorTheGrid(int m, int n) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(1);
        set.add(2);
        for (int i = 2; i <= m; i++) {
        	set = addOneColumn(set);
        }
        
        Map<Integer, Set<Integer>> nexts = new HashMap<>();
        for (int i : set) nexts.put(i, new HashSet<>());
        for (int i : set) {
        	for (int j : set) {
        		if (canBeAdjacent(i, j, m)) nexts.get(i).add(j);
        		
        	}
        }
        Map<Integer, Long> counts = new HashMap<>();
        long mod = (long)(1e9 + 7);
        for (int i : set) counts.put(i, 1l);
        for (int i = 1; i < n; i++) {
        	Map<Integer, Long> temp = new HashMap<>();
        	for (Map.Entry<Integer, Long> entry : counts.entrySet()) {
        		for (int next : nexts.get(entry.getKey())) {
        			temp.put(next, (temp.getOrDefault(next, 0l) + entry.getValue()) % mod);
        		}
        	}
        	counts = temp;
        }
        long result = 0;
        for (long val : counts.values()) {
        	result = (result + val) % mod;
        }
        return (int)result;
    }
	
	private boolean canBeAdjacent(int i, int j, int m) {
		for (int k = 0; k < m; k++) {
			if ((i & 7) == (j & 7)) return false;
			i >>= 3;
			j >>= 3;
		}
		return true;
	}

	private Set<Integer> addOneColumn(Set<Integer> set) {
		Set<Integer> result = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			for (int x : set) {
				if (i == (x & 7)) continue;
				result.add((x << 3) | i);
			}
		}
		return result;
	}
}
