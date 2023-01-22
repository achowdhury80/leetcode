package com.prep2020.medium;

import java.util.*;

public class Problem981 {
	private Map<String, TreeMap<Integer, String>> map;
	public Problem981() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
        treeMap.put(timestamp, value);
        map.put(key, treeMap);
    }
    
    public String get(String key, int timestamp) {
    	TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
    	Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
    	if (entry == null) return "";
    	return entry.getValue();
    }
}
