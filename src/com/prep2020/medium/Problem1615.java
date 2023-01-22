package com.prep2020.medium;
import java.util.*;
public class Problem1615 {
	public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] arr = new int[n];
        for (int[] r : roads) {
        	connected[r[0]][r[1]] = true;
        	connected[r[1]][r[0]] = true;
        	arr[r[0]]++;
        	arr[r[1]]++;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	List<Integer> cities = map.getOrDefault(arr[i], new ArrayList<>());
        	cities.add(i);
        	map.put(arr[i], cities);
        }
        
        Queue<Map.Entry<Integer, List<Integer>>> minQ 
        	= new PriorityQueue<>((x, y) -> x.getKey() - y.getKey());
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        	minQ.offer(entry);
        	if (minQ.size() > 2) minQ.poll();
        }
        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>();
        while(!minQ.isEmpty()) {
        	list.add(0, minQ.poll());
        }
        int result = Integer.MIN_VALUE, maxConn = list.get(0).getKey();
        
        if (list.get(0).getValue().size() > 1) {
        	List<Integer> cities = list.get(0).getValue();
        	for (int i : cities) {
        		for (int j : cities) {
        			if (i != j) {
        				result = Math.max(result, 
        						2 * maxConn - (connected[i][j] ? 1 : 0));
        			}
        		}
        	}
        	return result;
        }
        int city1 = list.get(0).getValue().get(0);
        for (int city2 : list.get(1).getValue()) {
        	result = Math.max(result, 
        			maxConn + list.get(1).getKey() - (connected[city1][city2] ? 1 : 0));
        }
        return result;
    }
}
