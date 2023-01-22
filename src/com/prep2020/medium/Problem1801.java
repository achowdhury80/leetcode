package com.prep2020.medium;
import java.util.*;
public class Problem1801 {
	/**
	 * O(mlogm + nlogn)
	 * O(m + n)
	 * @param orders
	 * @return
	 */
	public int getNumberOfBacklogOrders(int[][] orders) {
		int mod = (int)(1e9 + 7);
        Queue<int[]> buyQ = new PriorityQueue<>((x, y) -> y[0] - x[0]),
        		sellQ = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        int result = 0;
        for (int[] order : orders) {
        	if (order[2] == 0) {
        		while(order[1] > 0 && !sellQ.isEmpty() 
        				&& sellQ.peek()[0] <= order[0]) {
        			int min = Math.min(order[1], sellQ.peek()[1]);
        			order[1] -= min;
        			sellQ.peek()[1] -= min;
        			result = (int)((0l + result + mod - min) % mod);
        			if (sellQ.peek()[1] == 0) sellQ.poll();
        		}
        		if (order[1] > 0) {
        			buyQ.offer(new int[] {order[0], order[1]});
        			result = (result + order[1]) % mod;
        		}
        	} else {
        		while(order[1] > 0 && !buyQ.isEmpty() 
        				&& buyQ.peek()[0] >= order[0]) {
        			int min = Math.min(order[1], buyQ.peek()[1]);
        			order[1] -= min;
        			buyQ.peek()[1] -= min;
        			result = (int)((0l + result + mod - min) % mod);
        			if (buyQ.peek()[1] == 0) buyQ.poll();
        		}
        		if (order[1] > 0) {
        			sellQ.offer(new int[] {order[0], order[1]});
        			result = (result + order[1]) % mod;
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1801 problem = new Problem1801();
		System.out.println(problem.getNumberOfBacklogOrders(
				new int[][] {{7,1000000000,1},{15,3,0},{5,999999995,0},
				{5,1,1}}));
	}
}
