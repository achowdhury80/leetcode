package com.leet.algo;
import java.util.*;
public class Prob632 {
	public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) return new int[2];
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((x, y) -> x.get(0) - y.get(0));
        int max = Integer.MIN_VALUE, min, diff;
        for (List<Integer> list : nums) {
        	if (list == null || list.size() == 0) return new int[2];
        	pq.offer(list);
        	max = Math.max(max, list.get(0));
        }
        min = pq.peek().get(0);
        diff = max - min;
        int[] result = new int[] {min, max};
        while(pq.size() == nums.size()) {
        	List<Integer> l = pq.poll();
        	if (l.size() == 1) break;
        	l.remove(0);
        	pq.offer(l);
        	max = Math.max(max, l.get(0));
        	min = pq.peek().get(0);
        	if (diff > max - min) {
        		diff = max - min;
        		result[0] = min;
        		result[1] = max;
        	}
        }
        return result;
    }
}
