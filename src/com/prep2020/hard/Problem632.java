package com.prep2020.hard;
import java.util.*;
public class Problem632 {
	public int[] smallestRange(List<List<Integer>> nums) {
		Queue<int[]> pq = new PriorityQueue<>((x, y) -> nums.get(x[0]).get(x[1]) - nums.get(y[0]).get(y[1]));
        int[] result = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < nums.size(); i++) {
        	result[0] = Math.min(result[0], nums.get(i).get(0));
        	result[1] = Math.max(result[1], nums.get(i).get(0));
        	pq.offer(new int[] {i, 0});
        }
        int max = result[1];
        while(pq.size() == nums.size()) {
        	int[] cur = pq.poll();
        	if (nums.get(cur[0]).size() == cur[1] + 1) break;
        	cur[1]++;
        	pq.offer(cur);
        	max = Math.max(max, nums.get(cur[0]).get(cur[1]));
        	int[] peek = pq.peek();
        	if (result[1] - result[0] > max - nums.get(peek[0]).get(peek[1])) {
        		result = new int[] {nums.get(peek[0]).get(peek[1]), max};
        	}
        }
        
        return result;
    }
}
