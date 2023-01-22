package com.prep2020.medium;
import java.util.*;
public class Problem380 {
	private Map<Integer, Integer> map;
	private List<Integer> list;
	private Random random;
	public Problem380() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int last = list.get(list.size() - 1);
        if (last == val) {
        	map.remove(val);
        	list.remove(list.size() - 1);
        	return true;
        }
        int index = map.get(val);
        list.set(index, last);
        map.remove(val);
        list.remove(list.size() - 1);
        map.put(last, index);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
