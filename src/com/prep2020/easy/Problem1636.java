package com.prep2020.easy;
import java.util.*;
public class Problem1636 {
	/**
	 * O(NlogN)
	 * @param nums
	 * @return
	 */
	public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        Queue<Map.Entry<Integer, Integer>> q 
        	= new PriorityQueue<>((x, y) -> x.getValue() == y.getValue() 
        		? (y.getKey() - x.getKey()) : (x.getValue() - y.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) q.offer(entry);
        int[] result = new int[nums.length];
        int idx = 0;
        while(!q.isEmpty()) {
        	Map.Entry<Integer, Integer> entry = q.poll();
        	for (int i = 0; i < entry.getValue(); i++) {
        		result[idx++] = entry.getKey();
        	}
        }
        return result;
    }
}
