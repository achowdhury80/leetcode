package com.leet.algo;
import java.util.*;
public class Prob1086 {
	public int[][] highFive(int[][] items) {
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
        	int id = items[i][0];
        	if (!map.containsKey(id)) map.put(id, new PriorityQueue<>((x, y) -> x - y));
        	PriorityQueue<Integer> pq = map.get(id);
        	if (pq.size() < 5) pq.offer(items[i][1]);
        	else {
        		if (items[i][1] > pq.peek()) {
        			pq.poll();
        			pq.offer(items[i][1]);
        		}
        	}
        }
        int[][] result = new int[map.size()][2];
        int i = -1;
        for (int key : map.keySet()) {
        	i++;
        	PriorityQueue<Integer> pq = map.get(key); 
        	int j = 0, sum = 0;;
        	while(pq.size() > 0) {
        		sum += pq.poll();
        		j++;
        	}
        	result[i][0] = key;
        	result[i][1] = sum / j;
        }
        return result;
    }
}
