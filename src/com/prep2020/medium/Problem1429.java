package com.prep2020.medium;
import java.util.*;
public class Problem1429 {
	private Map<Integer, Integer> map;
	private List<Integer> list;
	private int last = 0;
	public Problem1429(int[] nums) {
        map = new HashMap<>();
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        	if (map.containsKey(nums[i])) {
        		map.put(nums[i], -1);
        	} else {
        		map.put(nums[i], list.size());
        		list.add(nums[i]);
        	}
        	
        }
    }
    
    public int showFirstUnique() {
        while(last < list.size() && map.get(list.get(last)) < 0) last++;
        return last == list.size() ? -1 : list.get(last);
    }
    
    public void add(int value) {
    	if (map.containsKey(value)) {
    		map.put(value, -1);
    	} else {
    		map.put(value, list.size());
    		list.add(value);
    	}
    }
}
