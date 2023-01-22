package com.prep2020.medium;
import java.util.*;
public class Problem1962 {
	/**
	 * O(n + k) logn
	 * O(n) space
	 * @param piles
	 * @param k
	 * @return
	 */
	public int minStoneSum(int[] piles, int k) {
        Queue<Integer> maxQ = new PriorityQueue<>((x, y) -> y - x);
        int result = 0;
        for (int p : piles) {
        	result += p;
        	maxQ.offer(p);
        }
        for (int i = 0; i < k; i++) {
        	int p = maxQ.poll();
        	if (p < 2) break;
        	result -= p / 2;
        	maxQ.offer(p - p / 2);
        }
        return result;
    }
}
