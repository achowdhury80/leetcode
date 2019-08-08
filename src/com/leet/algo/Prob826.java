package com.leet.algo;
import java.util.*;
public class Prob826 {
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int i = 0; i < profit.length; i++) {
        	pq.offer(new int[] {difficulty[i], profit[i]});
        }
        Arrays.sort(worker);
        int max = 0;
        int result = 0;
        for (int i = 0; i < worker.length; i++) {
        	while(!pq.isEmpty() && worker[i] >= pq.peek()[0]) {
        		max = Math.max(max, pq.poll()[1]);
        	}
        	result += max;
        }
        return result;
    }
}
