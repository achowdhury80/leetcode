package com.prep2020.medium;
import java.util.*;
public class Problem1418 {
	public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> foodItemSet = new HashSet<>();
        Map<Integer, Map<String, Integer>> tableMap = new HashMap<>();
        for (List<String> order : orders) {
        	Map<String, Integer> foodItems = tableMap.getOrDefault(Integer.parseInt(order.get(1)), new HashMap<>());
        	foodItems.put(order.get(2), foodItems.getOrDefault(order.get(2), 0) + 1);
        	foodItemSet.add(order.get(2));
        	tableMap.put(Integer.parseInt(order.get(1)), foodItems);
        }
        List<String> items = new ArrayList<>(foodItemSet);
        Collections.sort(items);
        List<List<String>> result = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        for (String item : items) header.add(item);
        result.add(header);
        List<Integer> tables = new ArrayList<>(tableMap.keySet());
        Collections.sort(tables);
        for (int table : tables) {
        	List<String> record = new ArrayList<>();
        	record.add("" + table);
        	for (String item : items) {
        		record.add("" + tableMap.get(table).getOrDefault(item, 0));
        	}
        	result.add(record);
        }
        return result;
	}
}