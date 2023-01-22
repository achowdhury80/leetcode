package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2034 {
	private Map<Integer, Integer> map;
	private TreeMap<Integer, Integer> priceMap;
	private int current = Integer.MIN_VALUE;
	public Problem2034() {
        map = new HashMap<>();
        priceMap = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        current = Math.max(current, timestamp);
        if (map.containsKey(timestamp)) {
        	int prevPrice = map.get(timestamp);
        	int count = priceMap.get(prevPrice);
        	count--;
        	if (count == 0) priceMap.remove(prevPrice);
        	else priceMap.put(prevPrice, count);
        }
        map.put(timestamp, price);
        priceMap.put(price, priceMap.getOrDefault(price, 0) + 1);
    }
    
    public int current() {
        return map.get(current);
    }
    
    public int maximum() {
        return priceMap.lastKey();
    }
    
    public int minimum() {
    	return priceMap.firstKey();
    }
}
