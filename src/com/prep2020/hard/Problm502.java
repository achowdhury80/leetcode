package com.prep2020.hard;
import java.util.*;
public class Problm502 {
	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		boolean speedUp = true;
        for (int c : capital) {
        	if (c > w) {
        		speedUp = false;
        		break;
        	}
        }
        int result = w, n = profits.length;
        if (speedUp) {
        	Arrays.sort(profits);
        	for (int i = 1; i <= k && (n - i) > -1; i++) {
        		result += profits[n - i];
        	}
        	return result;
        }
        boolean[] used = new boolean[n];
        Queue<Integer> minQCapital = new PriorityQueue<>((x, y) -> capital[x] - capital[y]);
        for (int i = 0; i < n; i++) minQCapital.offer(i);
        Queue<Integer> maxQAvailable = new PriorityQueue<>((x, y) -> profits[y] - profits[x]);
        while(k > 0 && (!minQCapital.isEmpty() || !maxQAvailable.isEmpty())) {
        	while(!minQCapital.isEmpty() && capital[minQCapital.peek()] <= result) {
        		int idx = minQCapital.poll();
        		if (!used[idx])maxQAvailable.offer(idx);
        	}
        	boolean found = false;
        	while(!maxQAvailable.isEmpty()) {
        		int idx = maxQAvailable.poll();
        		if (used[idx]) continue;
        		used[idx] = true;
        		found = true;
        		result += profits[idx];
        		break;
        	}
        	if (!found) break;
        	k--;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problm502 problem = new Problm502();
		//System.out.println(problem.findMaximizedCapital(2, 0, new int[] {1, 2, 3}, new int[] {0, 1, 1}));
		System.out.println(problem.findMaximizedCapital(1, 2, new int[] {1, 2, 3}, new int[] {1, 1, 2}));
	}
}
