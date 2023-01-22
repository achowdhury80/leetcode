package com.prep2020.medium;
import java.util.*;
public class Problem1488 {
	public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = 1;
        TreeSet<Integer> treeSet = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	if (rains[i] == 0) treeSet.add(i);
        	else {
        		result[i] = -1;
        		if (!map.containsKey(rains[i])) map.put(rains[i], i);
        		else {
        			Integer dryIndex = treeSet.higher(map.get(rains[i]));
        			if (dryIndex == null) return new int[0];
        			result[dryIndex] = rains[i];
        			treeSet.remove(dryIndex);
        			map.put(rains[i], i);
        		}
        	}
        }
        return result;
    }
}
