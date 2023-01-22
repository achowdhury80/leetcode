package com.prep2020.hard;
import java.util.*;
public class Problem815 {
	public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, Set<Integer>> stationToBusMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
        	for (int j : routes[i]) {
        		Set<Integer> buses = stationToBusMap.getOrDefault(j, new HashSet<>());
        		buses.add(i);
        		stationToBusMap.put(j, buses);
        	}
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        int result = 0;
        boolean[] usedBus = new boolean[routes.length];
        Set<Integer> visitedStation = new HashSet<>();
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		if (!stationToBusMap.containsKey(cur)) continue;
        		for (int bus : stationToBusMap.get(cur)) {
        			if (usedBus[bus]) continue;
        			usedBus[bus] = true;
        			for (int j : routes[bus]) {
        				if (j == target) return result;
        				if (visitedStation.contains(j)) continue;
        				visitedStation.add(j);
        				q.offer(j);
        			}
        		}
        		
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Problem815 problem = new Problem815();
		System.out.println(problem.numBusesToDestination(new int[][] {{1, 2, 7}, {3, 6, 7}}, 1, 6));
	}
}
