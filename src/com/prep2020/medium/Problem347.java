package com.prep2020.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem347 {
	/**
	 * NlogK
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(
        		(x, y) -> x.getValue() - y.getValue());
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	q.offer(entry);
        	if (q.size() > k) q.poll();
        }
        int[] result = new int[k];
        int idx = 0;
        while(!q.isEmpty())result[idx++] = q.poll().getKey();
        return result;
    }
}
