package com.prep2020.medium;
import java.util.*;
public class Problem1146 {
	private Map<Integer, Map<Integer, Integer>> map;
	private int snapId;
	public Problem1146(int length) {
        map = new HashMap<>();
        map.put(snapId, new HashMap<>());
    }
    
    public void set(int index, int val) {
    	Map<Integer, Integer> valueMap = map.getOrDefault(snapId, 
    			new HashMap<>());
    	valueMap.put(index, val);
    	map.put(snapId, valueMap);
    }
    
    public int snap() {
        int result = snapId++;
        Map<Integer, Integer> valueMap = new HashMap<>(map.get(result));
        map.put(snapId, valueMap);
        return result;
    }
    
    public int get(int index, int snap_id) {
    	Map<Integer, Integer> valueMap = map.get(snap_id);
    	return valueMap.containsKey(index) ? valueMap.get(index) : 0;
    }
    
    public static void main(String[] args) {
    	Problem1146 problem = new Problem1146(3);
    	problem.set(0, 5);
    	problem.snap();
    	problem.set(0, 6);
    	System.out.println(problem.get(0, 0));
    }
}
