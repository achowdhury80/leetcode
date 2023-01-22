package com.prep2020.medium;
import java.util.*;
public class Problem984 {
	/**
	 * O(a + b)
	 * @param a
	 * @param b
	 * @return
	 */
	public String strWithout3a3b(int a, int b) {
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        pq.offer(new int[] {0, a});
        pq.offer(new int[] {1, b});
        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (result.length() < 2 || result.charAt(result.length() - 2) != result.charAt(result.length() - 1)
        			|| result.charAt(result.length() - 1) != (char)(cur[0] + 'a')) {
        		result.append((char)(cur[0] + 'a'));
        		cur[1]--;
        		if(cur[1] > 0) pq.offer(cur);
        	} else {
        		int[] other = pq.poll();
        		pq.offer(cur);
        		result.append((char)(other[0] + 'a'));
        		other[1]--;
        		if(other[1] > 0) pq.offer(other);
        	}
        }
        return result.toString();
    }
}
