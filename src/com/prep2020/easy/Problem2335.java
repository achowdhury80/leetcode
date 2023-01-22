package com.prep2020.easy;
import java.util.*;
public class Problem2335 {
	public int fillCups(int[] amount) {
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i : amount) {
        	if (i > 0) pq.offer(i);
        }
        int result = 0;
        while(pq.size() > 1) {
        	int max = pq.poll(), next = pq.poll();
        	result++;
        	max--;
        	next--;
        	if (max > 0) {
        		pq.offer(max);
        		if (next > 0) pq.offer(next);
        	}
        }
        if (!pq.isEmpty()) result += pq.poll();
        return result;
    }
}
