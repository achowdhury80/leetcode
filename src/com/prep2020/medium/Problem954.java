package com.prep2020.medium;
import java.util.*;
public class Problem954 {
	public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : arr) {
        	treeSet.add(i);
        	map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (map.getOrDefault(0, 0) % 2 != 0) return false;
        map.remove(0);
        treeSet.remove(0);
        for (int i : treeSet) {
        	if (map.get(i) == 0) continue;
        	if (i < 0) {
        		if (i % 2 != 0) return false;
        		if (map.getOrDefault(i / 2, 0) < map.get(i)) return false;
        		map.put(i / 2, map.get(i / 2) - map.get(i));
        	} else {
        		if (map.getOrDefault(2 * i, 0) < map.get(i)) return false;
        		map.put(2 * i, map.get(2 * i) - map.get(i));
        	}
        	
        }
        return true;
    }
}
