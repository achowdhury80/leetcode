package com.prep2020.hard;
import java.util.*;
public class Problem715 {
	private TreeMap<Integer, Integer> treeMap;

    public Problem715() {
        treeMap = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        int start = left, end = right;
        Map.Entry<Integer, Integer> entry;
        while ((entry = treeMap.floorEntry(end)) != null) {
            if (entry.getValue() < start) break;
            start = Math.min(start, entry.getKey());
            end = Math.max(end, entry.getValue());
            treeMap.remove(entry.getKey());
        }
        treeMap.put(start, end);
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = treeMap.floorEntry(right);
        return entry != null && entry.getKey() <= left && entry.getValue() >= right;
    }

    public void removeRange(int left, int right) {
        int start = left, end = right;
        Map.Entry<Integer, Integer> entry;
        while ((entry = treeMap.lowerEntry(end)) != null) {
            if (entry.getValue() < start) break;
            treeMap.remove(entry.getKey());
            if (entry.getKey() < start) treeMap.put(entry.getKey(), start);
            if (entry.getValue() > end) treeMap.put(end, entry.getValue());
            end = entry.getKey();
            if (end <= start) break;
        }
    }
    
    public static void main(String[] args) {
    	Problem715 problem = new Problem715();
    	problem.addRange(10, 20);
    	problem.removeRange(14, 16);
    	System.out.println(problem.queryRange(10, 14));
    	System.out.println(problem.queryRange(13, 15));
    	System.out.println(problem.queryRange(16, 17));
    	
    }
    
}
