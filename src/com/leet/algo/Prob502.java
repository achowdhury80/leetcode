package com.leet.algo;
import java.util.*;
public class Prob502 {
	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        List<Integer> unused = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (int i = 0; i < Profits.length; i++) {
        	if (Capital[i] <= W) pq.offer(new int[] {Profits[i], Capital[i]});
	        else unused.add(i);
        }
        int curCapital = W;
        int result = W;
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
        	int[] arr = pq.poll();
        	result += arr[0];
        	curCapital += arr[0];
        	List<Integer> temp = new ArrayList<>();
        	for (int j = 0; j < unused.size(); j++) {
        		int x = unused.get(j);
        		if (Capital[x] <= curCapital) pq.offer(new int[] {Profits[x], Capital[x]});
            	else temp.add(x);
        	}
        	unused = temp;
        }
        return result;
    }
	
	
	public static void main(String[] args) {
		Prob502 prob = new Prob502();
		System.out.println(prob.findMaximizedCapital(2, 0, new int[] {1,  2, 3}, new int[] {0, 1, 1}));
		System.out.println(prob.findMaximizedCapital(3, 0, new int[] {1,  2, 3}, new int[] {0, 1, 2}));
		System.out.println(prob.findMaximizedCapital(1, 2, new int[] {1,  2, 3}, new int[] {1, 1, 2}));
		System.out.println(prob.findMaximizedCapital(11, 11, new int[] {1,  2, 3}, new int[] {11, 12, 13}));
		
	}
}
