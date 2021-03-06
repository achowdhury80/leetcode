package com.leet.algo;
import java.util.*;
public class Prob414 {
	public int thirdMax(int[] nums) {
        Queue<Integer> q = new PriorityQueue<>((x, y) -> (0l + x - y) <= 0 ? -1 : 1);
        
        for (int a : nums) {
        	if (q.contains(a)) continue;
        	if (q.size() > 2 && q.peek() < a) {
        		q.poll();
        		q.offer(a);
        	} else if (q.size() < 3) q.offer(a);
        }
        if (q.size() == 3) return q.poll();
        while(q.size() > 1) q.poll();
        return q.poll();
    }
	
	public static void main(String[] args) {
		Prob414 prob = new Prob414();
		System.out.println(prob.thirdMax(new int[] {-2147483648,1,1}));
	}
}
