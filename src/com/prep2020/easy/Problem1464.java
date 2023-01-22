package com.prep2020.easy;
import java.util.*;
public class Problem1464 {
	/*
	 * O(N) time
	 */
	public int maxProduct(int[] nums) {
        Queue<Integer> minQ = new PriorityQueue<>();
        for (int num : nums) {
        	minQ.offer(num);
        	if (minQ.size() > 2) minQ.poll();
        }
        return (minQ.poll() - 1) * (minQ.poll() - 1);
    }
}
