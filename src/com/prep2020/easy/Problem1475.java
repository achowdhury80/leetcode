package com.prep2020.easy;
import java.util.*;
public class Problem1475 {
	/**
	 * O(N) time and space
	 * @param prices
	 * @return
	 */
	public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = prices.length - 1; i> -1; i--) {
        	while(!dq.isEmpty() && dq.peekLast() > prices[i]) dq.pollLast();
        	if (!dq.isEmpty()) result[i] = prices[i] - dq.peekLast();
        	else result[i] = prices[i];
        	dq.offer(prices[i]);
        }
        return result;
    }
}
