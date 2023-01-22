package com.prep2020.hard;
import java.util.*;
public class Problem2251 {
	public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
		int n = persons.length;
        int[] result = new int[n];
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int i = 0; i < persons.length; i++) pq.offer(new int[] {persons[i], i});
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int[] f : flowers) {
        	treeMap.put(f[0], treeMap.getOrDefault(f[0], 0) + 1);
        	treeMap.put(f[1] + 1, treeMap.getOrDefault(f[1] + 1, 0) - 1);
        }
        int cur = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
        	while(!pq.isEmpty() && pq.peek()[0] < entry.getKey()) {
        		result[pq.poll()[1]] = cur;
        	}
        	cur += entry.getValue();
        	if (pq.isEmpty()) break;
        }
        while(!pq.isEmpty()) {
        	result[pq.poll()[1]] = cur;
        }
        return result;
    }
}
