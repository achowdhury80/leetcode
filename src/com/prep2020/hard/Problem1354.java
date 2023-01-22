package com.prep2020.hard;
import java.util.*;
public class Problem1354 {
	public boolean isPossible(int[] target) {
		if (target.length == 1) return target[0] == 1;
        long sum = 0;
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int a : target) {
        	pq.offer(a);
        	sum += a;
        }
        while(!pq.isEmpty() && pq.peek() > 1) {
        	int max = pq.poll();
        	long preSum = sum - max;
        	if (preSum == 1) return true;
        	int delta = (int)(max % preSum);
        	if (delta == 0 || delta == max) return false;
        	sum = sum - max + delta;
        	pq.offer((int)(delta));
        }
        return true;
    }
	
	public static void main(String[] args) {
		Problem1354 problem = new Problem1354();
		System.out.println(problem.isPossible(new int[] {9, 3, 5}));
	}
}
