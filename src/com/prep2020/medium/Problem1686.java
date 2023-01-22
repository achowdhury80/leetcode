package com.prep2020.medium;

import java.util.*;

public class Problem1686 {
	public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = bobValues.length;
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (int i = 0; i < n; i++) pq.offer(new int[] {aliceValues[i] + bobValues[i], 
        		aliceValues[i], bobValues[i]});
        boolean turn = true;
        int a = 0, b = 0;
        while (!pq.isEmpty()) {
        	if (turn) a += pq.poll()[1];
        	else b += pq.poll()[2];
        	turn = !turn;
        }
        return Integer.compare(a, b);
    }
	
	public static void main(String[] args) {
		Problem1686 problem = new Problem1686();
		System.out.println(problem.stoneGameVI(new int[] {1, 2}, 
				new int[] {3, 1}));
	}
}
