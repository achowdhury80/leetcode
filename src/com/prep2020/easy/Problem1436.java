package com.prep2020.easy;
import java.util.*;
public class Problem1436 {
	/**
	 * O(N) time and space
	 * @param paths
	 * @return
	 */
	public String destCity(List<List<String>> paths) {
        Map<String, Boolean> map = new HashMap<>();
        for (List<String> path : paths) {
        	map.put(path.get(0), false);
        	map.put(path.get(1), map.getOrDefault(path.get(1), true));
        }
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
        	if (entry.getValue()) return entry.getKey();
        }
        return null;
    }
}
