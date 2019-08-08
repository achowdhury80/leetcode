package com.leet.algo;
import java.util.*;
public class Prob1058 {
	public String minimizeError(String[] prices, int target) {
        Map<Integer, Double> map = new HashMap<>();
        map.put(0, 0.0);
        for (int i = 0; i < prices.length; i++) {
        	double price = Double.parseDouble(prices[i]);
        	int upper = (int)Math.ceil(price);
        	int lower = (int)Math.floor(price);
        	Map<Integer, Double> newMap = new HashMap<>();
        	for (Map.Entry<Integer, Double> entry : map.entrySet()) {
        		int upperKey = entry.getKey() + upper;
        		int lowerKey = entry.getKey() + lower;
        		newMap.put(upperKey, Math.min(newMap.getOrDefault(upperKey, Double.MAX_VALUE), entry.getValue() + (upper - price)));
        		newMap.put(lowerKey, Math.min(newMap.getOrDefault(lowerKey, Double.MAX_VALUE), entry.getValue() + (price - lower)));
        	}
        	map = newMap;
        }
        
        if (map.containsKey(target)) {
        	return String.format("%.3f", map.get(target));
        }
        return "-1";
    }
}
