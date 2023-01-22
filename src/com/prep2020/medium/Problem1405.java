package com.prep2020.medium;
import java.util.*;
public class Problem1405 {
	/**
	 * Greedy O(a + b + c)
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        int[] arr = new int[] {a, b, c};
        char[] chars = new char[] {'a', 'b', 'c'};
        Queue<Integer> q = new PriorityQueue<>((x, y) -> arr[y] - arr[x]);
        if (arr[0] > 0) q.offer(0);
        if (arr[1] > 0) q.offer(1);
        if (arr[2] > 0) q.offer(2);
        char[] last = new char[] {'c', 'd'};
        while(!q.isEmpty()) {
        	int idx = q.poll();
        	char ch = chars[idx];
        	int skipIdx = -1;
        	if (ch == last[0] && ch == last[1]) {
        		if (q.isEmpty()) return result.toString();
        		skipIdx = idx;
        		idx = q.poll();
        		ch = chars[idx];
        	} 
        	result.append(ch);
    		arr[idx]--;
            if (arr[idx] > 0) q.offer(idx);
            last[0] = last[1];
            last[1] = ch;
            if (skipIdx != -1) q.offer(skipIdx);
        }
        return result.toString();
    }
	
	public static void main(String[] args) {
		Problem1405 problem = new Problem1405();
		System.out.println(problem.longestDiverseString(1, 1, 7));
	}
}
