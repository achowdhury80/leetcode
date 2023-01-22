package com.prep2020.medium;
import java.util.*;
public class Problem1167 {
	/**
	 * O(NLogN) time and O(N) space
	 * @param sticks
	 * @return
	 */
	public int connectSticks(int[] sticks) {
        Queue<Integer> minQ = new PriorityQueue<>();
        for (int stick : sticks) minQ.offer(stick);
        int result = 0;
        while(minQ.size() > 1) {
        	int sum = minQ.poll() + minQ.poll();
        	result += sum;
        	minQ.offer(sum);
        }
        return result;
    }
}
