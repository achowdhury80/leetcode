package com.leet.algo;
import java.util.*;
public class Prob1046 {
	public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int s : stones) pq.offer(s);
        while(pq.size() > 1) {
        	int x = pq.poll();
        	int y = pq.poll();
        	if (x == y) continue;
        	pq.offer(x - y);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
