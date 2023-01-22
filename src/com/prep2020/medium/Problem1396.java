package com.prep2020.medium;
import java.util.*;
public class Problem1396 {
	private Map<String, int[]> map;
	private Map<Integer, Pair> userMap;
	public Problem1396() {
        map = new HashMap<>();
        userMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
    	userMap.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair pair = userMap.remove(id);
        int timeTaken = t - pair.t;
        String key = pair.name + "#" + stationName;
        int[] arr = map.getOrDefault(key, new int[2]);
        arr[0] += timeTaken;
        arr[1]++;
        map.put(key, arr);
    }
    
    public double getAverageTime(String startStation, String endStation) {
    	String key = startStation + "#" + endStation;
    	int[] arr = map.get(key);
    	return (arr[0] + 0.) / arr[1];
    }
    
    class Pair {
    	String name;
    	int t;
    	Pair(String name, int t) {
    		this.name = name;
    		this.t = t;
    	}
    }
}
