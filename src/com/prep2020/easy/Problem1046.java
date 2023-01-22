package com.prep2020.easy;
import java.util.*;
public class Problem1046 {
	/**
	 * O(NlogN)
	 * @param stones
	 * @return
	 */
	public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
        for (int s : stones) q.offer(s);
        while(q.size() > 1) {
        	int rem = q.poll() - q.poll();
        	if (rem > 0) q.offer(rem);
        }
        return q.size() == 1 ? q.poll() : 0;
    }
}
