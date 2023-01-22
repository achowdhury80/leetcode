package com.prep2020.medium;
import java.util.*;
public class Problem1753 {
	/**
	 * O(a + b + c)
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int maximumScore(int a, int b, int c) {
        Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
        q.offer(a);
        q.offer(b);
        q.offer(c);
        int result = 0;
        while(q.size() > 1) {
        	result++;
        	int x = q.poll();
        	int y = q.poll();
        	x--;
        	y--;
        	if (x > 0) q.offer(x);
        	if (y > 0) q.offer(y);
        }
        return result;
    }
}
