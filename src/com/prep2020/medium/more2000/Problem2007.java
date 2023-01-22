package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2007 {
	/**
	 * O(nlogN)
	 * @param changed
	 * @return
	 */
	 	public int[] findOriginalArray(int[] changed) {
	        int n = changed.length;
	        if (n % 2 == 1) return new int[0];
	        int[] result = new int[n / 2];
	        Map<Integer, Integer> map = new HashMap<>();
	        TreeSet<Integer> treeSet = new TreeSet<>();
	        for (int i : changed) {
	        	map.put(i, map.getOrDefault(i, 0) + 1);
	        	treeSet.add(i);
	        }
	        int idx = 0;
	        for (int i : treeSet) {
	        	if (map.get(i) == 0) continue;
	        	if (i == 0) {
	        		if (map.get(i) % 2 == 1) return new int[0];
	        		idx += map.get(i) / 2;
	        		map.put(0, 0);
	        	} else {
	        		int count = map.get(i);
	        		int doubleCount = map.getOrDefault(2 * i, 0);
	        		if (doubleCount < count) return new int[0];
	        		map.put(2 * i, doubleCount - count);
	        		map.put(i, 0);
	        		for (int j = 0; j < count; j++) result[idx++] = i;
	        	}
	        }
	        return result;
	    }
}
