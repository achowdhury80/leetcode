package com.prep2020.medium;
import java.util.*;
public class Problem1921 {
	public int eliminateMaximum(int[] dist, int[] speed) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
        	int time = dist[i] / speed[i] + (dist[i] % speed[i] != 0 ? 1 : 0);
        	pq.offer(time);
        }
        
        int curTime = 0, result = 0;
        while(!pq.isEmpty() && pq.peek() > curTime) {
        	pq.poll();
        	result++;
        	curTime++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1921 problem = new Problem1921();
		System.out.println(problem.eliminateMaximum(new int[] {1, 3, 4}, new int[] {1, 1, 1}));
	}
}
