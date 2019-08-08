package com.leet.algo;
import java.util.*;
public class Prob981 {
	private Map<String, TreeMap<Integer, String>> map;
	public Prob981() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
    	if (!map.containsKey(key)) map.put(key, new TreeMap<>());
    	TreeMap<Integer, String> treeMap = map.get(key);
        treeMap.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        TreeMap<Integer, String> treeMap = map.get(key);
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        if (entry == null) return "";
        return entry.getValue();
    }
    
    public static void main(String[] args) {
    	Prob981 prob = new Prob981();
    	prob.set("foo", "bar", 1);
    	System.out.println(prob.get("foo", 1));
    }
}
