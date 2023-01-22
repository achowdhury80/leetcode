package com.prep2020.medium;
import java.util.*;
public class Problem692 {
	/**
	 * O(NlogK) time and O(N) space
	 * @param words
	 * @param k
	 * @return
	 */
	public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
        		(x, y) -> (x.getValue() == y.getValue() ? 
        				(y.getKey().compareTo(x.getKey())) 
        				: (x.getValue() - y.getValue())));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        	pq.offer(entry);
        	if (pq.size() > k) pq.poll();
        }
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()) result.add(0, pq.poll().getKey());
        return result;
    }
}
