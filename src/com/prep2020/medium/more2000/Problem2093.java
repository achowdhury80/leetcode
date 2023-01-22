package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2093 {
	public int minimumCost(int n, int[][] highways, int discounts) {
        int[][] minToll = new int[n][discounts + 1];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j <= discounts; j++) 
        		minToll[i][j] = Integer.MAX_VALUE;
        }
        List<int[]>[] nexts = new List[n];
        for (int i = 0; i < n; i++) nexts[i] = new ArrayList<>();
        for (int[] hw : highways) {
        	nexts[hw[0]].add(new int[] {hw[1], hw[2]});
        	nexts[hw[1]].add(new int[] {hw[0], hw[2]});
        }
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[] {0, 0, 0});
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (cur[0] == n - 1) return cur[1];
        	for(int[] next : nexts[cur[0]]) {
        		if ((cur[1] + next[1]) < minToll[next[0]][cur[2]]) {
        			minToll[next[0]][cur[2]] = cur[1] + next[1];
        			pq.offer(new int[] {next[0], cur[1] + next[1], cur[2]});
        		}
        		
        		if (cur[2] < discounts 
        				&& ((cur[1] + next[1] / 2) < minToll[next[0]][cur[2]] + 1)) {
        			minToll[next[0]][cur[2] + 1] = cur[1] + next[1] / 2;
        			pq.offer(new int[] {next[0], cur[1] + next[1] / 2, cur[2] + 1});
        		}
        	}
        }
        
        return -1;
    }
}
