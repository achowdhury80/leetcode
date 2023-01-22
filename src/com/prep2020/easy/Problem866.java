package com.prep2020.easy;
import java.util.*;
public class Problem866 {
	public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
        	Queue<Integer> q = map.getOrDefault(item[0], new PriorityQueue<>());
        	q.offer(item[1]);
        	if (q.size() > 5) q.poll();
        	map.put(item[0], q);
        }
        int[][] result = new int[map.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
        	int sum = 0;
        	Queue<Integer> q = entry.getValue();
        	while(!q.isEmpty()) sum += q.poll();
        	result[idx++] = new int[] {entry.getKey(), sum / 5};
        }
        Arrays.sort(result, (x, y) -> x[0] - y[0]);
        return result;
    }
}
